#!/usr/bin/python
import smtplib
import sys

def multi_input():
        try:
            while True:
                data = input()
                if not data: pass
                yield data
        except:
            return
if __name__ == '__main__':
    try:
        args = sys.argv[1:]

        if not args: sys.exit(1)

        if args[0] == "outlook":
            emailAddr = "desp0021@algonquinlive.com"
            emailPass = "Jordan2469$"
            emailServ = "smtp.live.com:587"
        elif args[0] == "gmail":
            emailAddr = "tdespatie@gmail.com"
            emailPass = "24692469"
            emailServ = "smtp.gmail.com:587"
        else:
            sys.exit(1)

        to = input('To: ').rstrip()
        cc = input('CC: ').rstrip()
        subject = input('Subject: ').rstrip()

        message = '\r\n'.join(['To: %s' % to,
                               'From: Tyler Despatie',
                               'CC: %s' % cc,
                               'Subject: %s' % subject,
                               '\r\n'.join(list(multi_input()))])

        server = smtplib.SMTP(emailServ)
        server.starttls()
        server.login(emailAddr, emailPass)
        server.sendmail(emailAddr, to, message)
        server.quit()
        print('\nSent e-mail to: ' + to + " using: " + emailAddr)

    except:
        print("Usage: ./send-email.py <gmail>||<outlook>")
        sys.exit(1)
