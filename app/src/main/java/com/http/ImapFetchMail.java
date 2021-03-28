//package com.http;
//
//import android.widget.SimpleAdapter;
//
//import com.sun.mail.imap.IMAPFolder;
//import com.sun.mail.imap.IMAPStore;
//import com.tools.AppTools;
//
//import java.io.File;
//import java.security.Security;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//
//import javax.mail.Flags;
//import javax.mail.Folder;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.NoSuchProviderException;
//import javax.mail.Part;
//import javax.mail.Session;
//import javax.mail.Store;
//import javax.mail.URLName;
//import javax.mail.internet.MimeMessage;
//
//public class ImapFetchMail extends Thread {
//
//    private Properties props;
//
//    String username = "urssizlynnm@outlook.com";
//    String password = "qHbKoT367";
//
//
//    @Override
//    public void run() {
////        String dd = ImapFetchMail.getVcode("edthvkjjmchuvij@outlook.com", "wIzQsT808");
//
//        ImapFetchMail ff = new ImapFetchMail();
//
//        ff.getEmail();
//
////        AppTools.show(dd);
//
//    }
//
//    public static void main(String[] args) {
//        ImapFetchMail.getVcode("edthvkjjmchuvij@outlook.com", "wIzQsT808");
//
//    }
//
//    public static String getVcode(String username, String password) {
//
//        IMAPFolder folder = null;
//        IMAPStore store = null;
//        String vcode = null;
//        try {
//            getProp();
//            store = (IMAPStore) session.getStore("imap");  // 使用imap会话机制，连接服务器
//            store.connect(host, port, username, password);
//            folder = (IMAPFolder) store.getFolder("INBOX"); //收件箱
//
//            // 使用只读方式打开收件箱
//            folder.open(Folder.READ_ONLY);
//            int size = folder.getMessageCount();
//            System.out.println("这里是打印的条数==" + size);
//            Message[] mess = folder.getMessages();
//            //  Message message = folder.getMessage(size);
//            for (int i = 0; i < mess.length; i++) {
//                String from = mess[i].getFrom()[0].toString();
//                String subject = mess[i].getSubject();
//
//                if (subject.contains("FB-")) {
//                    vcode = subject.substring(subject.indexOf("FB-") + "FB-".length(), subject.indexOf(" "));
//                    break;
//                }
//
//                Date date = mess[i].getSentDate();
//                String dis = mess[i].getDisposition();
//
//                System.out.println("From: " + from);
//                System.out.println("Subject: " + subject);
//                System.out.println("Date: " + date);
//                System.out.println("dis: " + dis);
//            }
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (folder != null) {
//                    folder.close(false);
//                }
//                if (store != null) {
//                    store.close();
//                }
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//        }
//        return vcode;
//    }
//
//
//    static String host = "imap-mail.outlook.com";
//    static int port = 993;
//    static Session session;
//
//    public static void getProp() {
//        if (session == null) {
////            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
////            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//
//
//
//            Properties props = System.getProperties();
////            props.setProperty("mail.imap.socketFactory.class", SSL_FACTORY);
//            props.setProperty("mail.imap.socketFactory.port", "993");
//            props.setProperty("mail.store.protocol", "imap");
//            props.setProperty("mail.imap.host", host);
//            props.setProperty("mail.imap.port", "993");
//            props.setProperty("mail.imap.auth.login.disable", "true");
//            session = Session.getDefaultInstance(props, null);
//            session.setDebug(false);
//        }
//
//    }
//
//
//    /**
//     * 以pop3方式读取邮件，此方法不能读取邮件是否为已读，已经通过测试
//     * */
//    private void getEmail() {
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//
//        try {
//            Properties props = System.getProperties();
//            props.put("mail.smtp.host", "smtp-mail.outlook.com");
//            props.put("mail.smtp.auth", "true");
//
////            "edthvkjjmchuvij@outlook.com", "wIzQsT808"
//
//            Session session = Session.getDefaultInstance(props, null);
//            URLName urln = new URLName("pop3", "pop-mail.outlook.com",995, null,
//                    "edthvkjjmchuvij@outlook.com", "wIzQsT808");
//            // 邮件协议为pop3，邮件服务器是pop3.163.com，端口为110，用户名/密码为abcw111222/123456w
//            Store store = session.getStore(urln);
//            store.connect();
//            Folder folder = store.getFolder("INBOX");
//            folder.open(Folder.READ_ONLY);
//            Message message[] = folder.getMessages();
//            if (message.length > 0) {
//                Map<String, Object> map;
//                System.out.println("Messages's length: " + message.length);
//                ReciveOneMail pmm = null;
//                for (int i = 0; i < message.length; i++) {
//                    System.out.println("======================");
//                    pmm = new ReciveOneMail((MimeMessage) message[i]);
//                    System.out.println("Message " + i + " subject: "
//                            + pmm.getSubject());
//                    System.out.println("Message " + i + " sentdate: "
//                            + pmm.getSentDate());
//                    System.out.println("Message " + i + " replysign: "
//                            + pmm.getReplySign());
//
//                    boolean isRead = pmm.isNew();// 判断邮件是否为已读
//                    System.out.println("Message " + i + " hasRead: " + isRead);
//                    System.out.println("Message " + i + "  containAttachment: "
//                            + pmm.isContainAttach((Part) message[i]));
//                    System.out.println("Message " + i + " form: "
//                            + pmm.getFrom());
//                    System.out.println("Message " + i + " to: "
//                            + pmm.getMailAddress("to"));
//                    System.out.println("Message " + i + " cc: "
//                            + pmm.getMailAddress("cc"));
//                    System.out.println("Message " + i + " bcc: "
//                            + pmm.getMailAddress("bcc"));
//                    pmm.setDateFormat("yy年MM月dd日 HH:mm");
//                    System.out.println("Message " + i + " sentdate: "
//                            + pmm.getSentDate());
//                    System.out.println("Message " + i + " Message-ID: "
//                            + pmm.getMessageId());
//                    // 获得邮件内容===============
//                    pmm.getMailContent((Part) message[i]);
//                    System.out.println("Message " + i + " bodycontent: \r\n"
//                            + pmm.getBodyText());
//                    String file_path = File.separator + "mnt" + File.separator
//                            + "sdcard" + File.separator;
//                    System.out.println(file_path);
//                    pmm.setAttachPath(file_path);
//                    pmm.saveAttachMent((Part) message[i]);
//
//                    map = new HashMap<String, Object>();
//                    map.put("from", pmm.getFrom());
//                    map.put("title", pmm.getSubject());
//                    map.put("time", pmm.getSentDate());
//                    map.put("read", isRead);
//                    list.add(map);
//                }
////                SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,
////                        list, R.layout.item_receiveemail, new String[] {
////                        "from", "title", "time", "read" }, new int[] {
////                        R.id.item_receive_sendname,
////                        R.id.item_receive_title,
////                        R.id.item_receive_sendtime,
////                        R.id.item_receive_read });
////                lv.setAdapter(adapter);
//
//            } else {
////                Toast.makeText(MainActivity.this, "没有邮件", Toast.LENGTH_SHORT)
////                        .show();
//            }
//        } catch (NoSuchProviderException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//
//
//
//    private void getImapEmail() {
//
//
//
//
//        String user = "edthvkjjmchuvij@outlook.com";// 邮箱的用户名
//        String password = "wIzQsT808"; // 邮箱的密码
//
//        Properties prop = System.getProperties();
////        prop.put("mail.store.protocol", "imap");
////        prop.put("mail.imap.host", "imap.163.com");
//
//
//        prop.setProperty("mail.imap.socketFactory.port", "993");
//        prop.setProperty("mail.store.protocol", "imap");
//        prop.setProperty("mail.imap.host", host);
//        prop.setProperty("mail.imap.port", "993");
//        prop.setProperty("mail.imap.auth.login.disable", "true");
//
//        Session session = Session.getInstance(prop);
//
//        int total = 0;
//        IMAPStore store;
//        try {
//            store = (IMAPStore) session.getStore("imap"); // 使用imap会话机制，连接服务器
//
//            store.connect(user, password);
//
//            IMAPFolder folder = (IMAPFolder) store.getFolder("INBOX"); // 收件箱
//            folder.open(Folder.READ_ONLY);
//            // 获取总邮件数
//            total = folder.getMessageCount();
//            System.out.println("---共有邮件：" + total + " 封---");
//            // 得到收件箱文件夹信息，获取邮件列表
//            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//            System.out.println("未读邮件数：" + folder.getUnreadMessageCount());
//            Message[] messages = folder.getMessages();
//            if (messages.length > 0) {
//                Map<String, Object> map;
//                System.out.println("Messages's length: " + messages.length);
//                ReciveOneMail pmm = null;
//                for (int i = 0; i < messages.length; i++) {
//                    System.out.println("======================");
//                    pmm = new ReciveOneMail((MimeMessage) messages[i]);
//                    System.out.println("Message " + i + " subject: "
//                            + pmm.getSubject());
//                    try {
//                        System.out.println("Message " + i + " sentdate: "
//                                + pmm.getSentDate());
//                        System.out.println("Message " + i + " replysign: "
//                                + pmm.getReplySign());
//
//                        boolean isRead;// 用来判断该邮件是否为已读
//                        String read;
//                        Flags flags = messages[i].getFlags();
//                        if (flags.contains(Flags.Flag.SEEN)) {
//                            System.out.println("这是一封已读邮件");
//                            isRead = true;
//                            read = "已读";
//                        } else {
//                            System.out.println("未读邮件");
//                            isRead = false;
//                            read = "未读";
//                        }
//                        System.out.println("Message " + i + " hasRead: "
//                                + isRead);
//                        System.out.println("Message " + i
//                                + "  containAttachment: "
//                                + pmm.isContainAttach((Part) messages[i]));
//                        System.out.println("Message " + i + " form: "
//                                + pmm.getFrom());
//                        System.out.println("Message " + i + " to: "
//                                + pmm.getMailAddress("to"));
//                        System.out.println("Message " + i + " cc: "
//                                + pmm.getMailAddress("cc"));
//                        System.out.println("Message " + i + " bcc: "
//                                + pmm.getMailAddress("bcc"));
//                        pmm.setDateFormat("yy年MM月dd日 HH:mm");
//                        System.out.println("Message " + i + " sentdate: "
//                                + pmm.getSentDate());
//                        System.out.println("Message " + i + " Message-ID: "
//                                + pmm.getMessageId());
//                        // 获得邮件内容===============
//                        pmm.getMailContent((Part) messages[i]);
//                        System.out.println("Message " + i
//                                + " bodycontent: \r\n" + pmm.getBodyText());
//                        String file_path = File.separator + "mnt"
//                                + File.separator + "sdcard" + File.separator;
//                        System.out.println(file_path);
//                        pmm.setAttachPath(file_path);
//                        pmm.saveAttachMent((Part) messages[i]);
//
//                        map = new HashMap<String, Object>();
//                        map.put("from", pmm.getFrom());
//                        map.put("title", pmm.getSubject());
//                        map.put("time", pmm.getSentDate());
//                        map.put("read", read);
//                        list.add(map);
//                    } catch (Exception e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//
//                }
////                SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,
////                        list, R.layout.item_receiveemail, new String[] {
////                        "from", "title", "time", "read" }, new int[] {
////                        R.id.item_receive_sendname,
////                        R.id.item_receive_title,
////                        R.id.item_receive_sendtime,
////                        R.id.item_receive_read });
////                lv.setAdapter(adapter);
//            }
//        } catch (javax.mail.NoSuchProviderException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (MessagingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//
//}
