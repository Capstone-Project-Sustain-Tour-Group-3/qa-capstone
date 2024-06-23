import Imap from 'node-imap';
import { simpleParser } from 'mailparser';

async function getVerificationCodeFromEmail(email, password) {
    return new Promise((resolve, reject) => {
        const imap = new Imap({
            user: email,
            password: password,
            host: 'imap.gmail.com', // Change this to your email provider's IMAP server
            port: 993,
            tls: true
        });

        function openInbox(cb) {
            imap.openBox('INBOX', true, cb);
        }

        imap.once('ready', function() {
            openInbox(function(err, box) {
                if (err) throw err;
                const f = imap.seq.fetch('1:10', { // Adjust range to check recent emails
                    bodies: ''
                });

                f.on('message', function(msg, seqno) {
                    let prefix = '(#' + seqno + ') ';
                    msg.on('body', function(stream, info) {
                        simpleParser(stream, (err, mail) => {
                            if (err) reject(err);
                            if (mail.subject.includes("Kode Verifikasi (OTP)")) { // Adjust subject filter
                                const code = mail.text.match(/\d{4}/); // Assuming code is 6 digits
                                if (code) {
                                    resolve(code[0]);
                                    imap.end();
                                }
                            }
                        });
                    });
                });

                f.once('error', function(err) {
                    reject(err);
                });

                f.once('end', function() {
                    imap.end();
                });
            });
        });

        imap.once('error', function(err) {
            reject(err);
        });

        imap.once('end', function() {
            console.log('Connection ended');
        });

        imap.connect();
    });
}