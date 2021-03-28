package com.action.ins.js;

public class InsJs {



    public static String findLogin1 = "javascript:var bs = document.getElementsByTagName('button');alert(bs.length);\n";


    public static String findLogin = "javascript: function findLogin(){" +
            "" +
            "var bs = document.getElementsByTagName('button');\n" +

            "for(  i = 0;i < bs.length;i++){\n" +
            "\tif(bs[i].innerText == \"Log In\")\n" +
            "\t\treturn 1;\n" +
            "\n" +
            "}" +
            "return 0;}" +"\n" +
            "findLogin();\n";


    public static String clickLogin = "javascript:function clickLogin(){" +
            "var bs = document.getElementsByTagName('button');\n" +
//            alert(bs[i].innerText);
            "for(  i = 0;i < bs.length;i++){\n" +
            "\tif(bs[i].innerText == \"Log In\"){\n" +
            "\t\tbs[i].click();" +
            "return 1;\n" +
            "}\n" +
            "}" +
            "return 0;" +
            "}" +
            "clickLogin();\n";




//    public static String setNameJs(String name,String value) {
//
//        String setName = "javascript:var name = '"+value+"';\n" +
//                "function setName(){"
//                +" var bs = document.getElementsByTagName('input');\n" +
//                "for(i = 0;i < bs.length;i++){\n" +
//                "   if(bs[i].name == '"+name+"'){" +
//
//                "bs[i].value=name;" +
//                "return 1;" +
//                "}\n" +
//
//                "\n" +
//                "}" +
//                "return 0;" +
//                "}\n" +
//                "setName();";
//
//        return setName;
//    }


    public static String setNameJs(String name,String value) {

        String setName = "javascript:var name = '"+value+"';\n" +
                "function setName(){"
                +" var bs = document.getElementsByTagName('input');\n" +
                "for(i = 0;i < bs.length;i++){\n" +
                "   if(bs[i].name == '"+name+"'){" +

//                "alert(bs[i].value);" +
                "bs[i].value = bs[i].value+'123';" +
                "" +
//                "bs[i].value=name;" +
                "return 1;" +
                "}\n" +

                "\n" +
                "}" +
                "return 0;" +
                "}\n" +
                "setName();";

        return setName;
    }


        public static String clickNameJs(String name){

//        String setName = "javascript:var name = '"+name+"';var pwd = '"+pwd+"';\n" +
//                "function setName(){"
//                +" var bs = document.getElementsByTagName('input');alert(bs.length);\n" +
//                "for(i = 0;i < bs.length;i++){\n" +
//                "   if(bs[i].name == 'username'){" +
//                "bs[i].click();" +
//                "bs[i].value=name;" +
//                "}\n" +
//                "if(bs[i].name == 'password'){\n" +
//                "bs[i].click(); " +
//                "bs[i].value=pwd;\n" +
//                " \n" +
//                " var ls = document.getElementsByTagName('button');\n" +
//                "for(  i = 0;i < ls.length;i++){\n" +
//                "\tif(ls[i].innerText == \"Log In\"){\n" +
//                "\t\tls[i].click();" +
//                "return 1;\n" +
//                "}\n" +
//                "}" +
//                " \n" +
//                " \n" +
//                " \n" +
//                "}" +
//                "\n" +
//                "}" +
//                "return 0;" +
//                "}\n" +
//                "setName();";



//        String setName = "javascript:var name = '"+name+"';var pwd = '"+pwd+"';\n" +
//                "function setName(){"
//                +"var bs = document.getElementsByTagName('input');alert(bs.length);\n" +
//                "for(i = 0;i < bs.length;i++){\n" +
//                "   if(bs[i].name == 'username'){" +
//                "bs[i].focus();" +
////                "bs[i].value=name;" +
//                "}\n" +
//
//                "}" +
//                "return 0;" +
//                "}\n" +
//                "setName();";



        String dd = "javascript:function getElementViewLeft(element){\n" +
                "　　　　var actualLeft = element.offsetLeft;\n" +
                "　　　　var current = element.offsetParent;\n" +
                "\n" +
                "　　　　while (current !== null){\n" +
                "　　　　　　actualLeft += current.offsetLeft;\n" +
                "　　　　　　current = current.offsetParent;\n" +
                "　　　　}\n" +
                "\n" +
                "　　　　if (document.compatMode == \"BackCompat\"){\n" +
                "　　　　　　var elementScrollLeft=document.body.scrollLeft;\n" +
                "　　　　} else {\n" +
                "　　　　　　var elementScrollLeft=document.documentElement.scrollLeft;\n" +
                "　　　　}\n" +
                "\n" +
                "　　　　return document.body.clientWidth +'_'+(actualLeft-elementScrollLeft);\n" +
                "　　}\n" +
                "\n" +
                "function getElementViewTop(element){\n" +
                "　　　　var actualTop = element.offsetTop;\n" +
                "　　　　var current = element.offsetParent;\n" +
                "\n" +
                "　　　　while (current !== null){\n" +
                "　　　　　　actualTop += current. offsetTop;\n" +
                "　　　　　　current = current.offsetParent;\n" +
                "　　　　}\n" +
                "\n" +
                "　　　　 if (document.compatMode == \"BackCompat\"){\n" +
                "　　　　　　var elementScrollTop=document.body.scrollTop;\n" +
                "　　　　} else {\n" +
                "　　　　　　var elementScrollTop=document.documentElement.scrollTop;\n" +
                "　　　　}\n" +
                "\n" +
                "　　　　return document.body.clientHeight +'_'+(actualTop-elementScrollTop);\n" +
                "　　}" +
                "" +
                "var bs = document.getElementsByTagName('input');" +
                "" +
                "function ss(){" +
                "for(i = 0;i < bs.length;i++){\n" +
                "   if(bs[i].name == '"+name+"'){\n" +
                "if(bs[i].value == '')" +
                "return getElementViewLeft(bs[i]) + '_'+ getElementViewTop(bs[i]);\n" +
                "else \n" +
                "return 'ok';\n" +

                "}\n" +

                "}" +


                "}\n" +

                "ss();";


////获取元素的纵坐标
//        function getTop(e){
//                var offset=e.offsetTop;
//        if(e.offsetParent!=null) offset+=getTop(e.offsetParent);
//        return offset;
//}
////获取元素的横坐标
//        function getLeft(e){
//                var offset=e.offsetLeft;
//        if(e.offsetParent!=null) offset+=getLeft(e.offsetParent);
//        return offset;
//}

        String ddc = "javascript:" +
                "function getTop(e){\n" +
                "                var offset=e.offsetTop;\n" +
                "        if(e.offsetParent!=null) offset+=getTop(e.offsetParent);\n" +
                "        return offset;\n" +
                "}" +
                "" +
                "\n" +
                "function getLeft(e){\n" +
                "                var offset=e.offsetLeft;\n" +
                "        if(e.offsetParent!=null) offset+=getLeft(e.offsetParent);\n" +
                "        return offset;\n" +
                "}" +
                "var bs = document.getElementsByTagName('input');\n" +
                "\n" +
                "\n" +
                "\n" +
                "\nfunction dd( ){" +
                "return getLeft(bs[0])+'   '+getTop(bs[0]) ;" +
                "" +
                "" +
                "" +
                "}\n" +
                "dd();" +
                "";

            return dd;
    }






}
