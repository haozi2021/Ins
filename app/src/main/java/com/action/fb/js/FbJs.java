package com.action.fb.js;

public class FbJs {


    public static String hasElement(String tag, String arg, String val) {
        String js = "javascript: function findFirst(){" +
                "var bs = document.getElementsByTagName('" + tag + "');\n" +
                "for(  i = 0;i < bs.length;i++){\n" +
                "\tif(bs[i]." + arg + " == \"" + val + "\")\n" +
                "\t\treturn 1;\n" +
                "\n" +
                "}" +
                "return 0;}" + "\n" +
                "findFirst();\n";

        return js;
    }


    public static String setSelect(String tag, String arg, String val) {
        String js = "javascript: function findFirst(){" +
                "var bs = document.getElementsByTagName('" + tag + "');\n" +
                "for(  i = 0;i < bs.length;i++){\n" +
                "\tif(bs[i]." + arg + " == \"" + val + "\")\n" +
                "\t\treturn bs[i];\n" +
                "\n" +
                "}" +
                "return null;}" + "\n" +
                "var ele = findFirst();\n" +
                "function random(min, max) {\n" +
                " \n" +
                "  return Math.floor(Math.random() * (max - min)) + min;\n" +
                " \n" +
                "}\n" +
                "function jsSelectItemByValue()  {\n" +
                "    var i = random(0, ele.options.length);\n" +
//                "    alert(i);\n" +
                "    ele.options[i].selected = true; " +
                "return 1; \n" +
                " \n" +
                "}\n" +
                "jsSelectItemByValue();";

        return js;
    }


//    public static String setSelect(String tag, String arg, String val) {
//        String js = "javascript: function findFirst(){" +
//                "var bs = document.getElementsByTagName('" + tag + "');\n" +
//                "for(  i = 0;i < bs.length;i++){\n" +
//                "\tif(bs[i]." + arg + " == \"" + val + "\")\n" +
//                "\t\treturn bs[i];\n" +
//                "\n" +
//                "}" +
//                "return null;}" + "\n" +
//                "var ele = findFirst();\n" +
//                "function random(min, max) {\n" +
//                " \n" +
//                "  return Math.floor(Math.random() * (max - min)) + min;\n" +
//                " \n" +
//                "}\n" +
//                "function jsSelectItemByValue()  {\n" +
//                "    var i = random(0, ele.options.length);\n" +
//                "    ele.options[i].selected = true; " +
//                "return 1; \n" +
//                " \n" +
//                "}\n" +
//                "jsSelectItemByValue();";
//
//        return js;
//    }


    public static String setSelect_var(String tag, String arg, String val, String val2) {
        String js = "javascript: function findFirst(){" +
                "var bs = document.getElementsByTagName('" + tag + "');\n" +
                "for(  i = 0;i < bs.length;i++){\n" +
                "\tif(bs[i]." + arg + " == \"" + val + "\")\n" +
                "\t\treturn bs[i];\n" +
                "\n" +
                "}" +
                "return null;}" + "\n" +
                "var ele = findFirst();\n" +
                "function random(min, max) {\n" +
                " \n" +
                "  return Math.floor(Math.random() * (max - min)) + min;\n" +
                " \n" +
                "}\n" +
                "function jsSelectItemByValue()  {\n" +
                "   \n" +
                "    for (var i = 0; i < ele.options.length; i++) {\n" +
                "        if (ele.options[i].text == '" + val2 + "') {\n" +
                "            ele.options[i].selected = true; \n" +
                "            return 1;\n" +
                "        }\n" +
                "    }\n" +
                " \n" +
                "}\n" +
                "jsSelectItemByValue();";

        return js;
    }


//
//    public static String clickCreate() {
//
//
//        String dd = "javascript:function getElementViewLeft(element){\n" +
//                "　　　　var actualLeft = element.offsetLeft;\n" +
//                "　　　　var current = element.offsetParent;\n" +
//                "\n" +
//                "　　　　while (current !== null){\n" +
//                "　　　　　　actualLeft += current.offsetLeft;\n" +
//                "　　　　　　current = current.offsetParent;\n" +
//                "　　　　}\n" +
//                "\n" +
//                "　　　　if (document.compatMode == \"BackCompat\"){\n" +
//                "　　　　　　var elementScrollLeft=document.body.scrollLeft;\n" +
//                "　　　　} else {\n" +
//                "　　　　　　var elementScrollLeft=document.documentElement.scrollLeft;\n" +
//                "　　　　}\n" +
//                "\n" +
//                "　　　　return document.body.clientWidth +'_'+(actualLeft-elementScrollLeft);\n" +
//                "　　}\n" +
//                "\n" +
//                "function getElementViewTop(element){\n" +
//                "　　　　var actualTop = element.offsetTop;\n" +
//                "　　　　var current = element.offsetParent;\n" +
//                "\n" +
//                "　　　　while (current !== null){\n" +
//                "　　　　　　actualTop += current. offsetTop;\n" +
//                "　　　　　　current = current.offsetParent;\n" +
//                "　　　　}\n" +
//                "\n" +
//                "　　　　 if (document.compatMode == \"BackCompat\"){\n" +
//                "　　　　　　var elementScrollTop=document.body.scrollTop;\n" +
//                "　　　　} else {\n" +
//                "　　　　　　var elementScrollTop=document.documentElement.scrollTop;\n" +
//                "　　　　}\n" +
//                "\n" +
//                "　　　　return document.body.clientHeight +'_'+(actualTop-elementScrollTop);\n" +
//                "　　}" +
//                "" +
//                "var bs = document.getElementsByTagName('a');\n" +
//                " \n" +
//                "function ss(){\n" +
//                "for(i = 0;i < bs.length;i++){\n" +
//                "   if(bs[i].innerText == 'Create New Account')\n" +
//                "\treturn getElementViewLeft(bs[i]) + '_'+ getElementViewTop(bs[i]);\n" +
//                "}\n" +
//                "return '0';\n" +
//                "}\n" +
//                "ss();";
//
//        return dd;
//    }


    public static String clickXy_Element(String tag, String arg, String val) {


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
                "var bs = document.getElementsByTagName('" + tag + "');\n" +
                " \n" +
                "function ss(){\n" +
                "for(i = 0;i < bs.length;i++){\n" +
                "   if(bs[i]." + arg + " == '" + val + "'){\n" +
                "\t bs[i].click();\n" +
                "return 1;\n" +
                "}\n" +
                "}\n" +
                "return '0';\n" +
                "}\n" +
                "ss();";

        return dd;
    }




    public static String getXy_Element(String tag, String arg, String val) {


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
                "var bs = document.getElementsByTagName('" + tag + "');\n" +
                " \n" +
                "function ss(){\n" +
                "for(i = 0;i < bs.length;i++){\n" +
                "   if(bs[i]." + arg + " == '" + val + "')\n" +
                "\treturn getElementViewLeft(bs[i]) + '_'+ getElementViewTop(bs[i]);\n" +
                "}\n" +
                "return '0';\n" +
                "}\n" +
                "ss();";

        return dd;
    }


    public static String getXy_Element_long(String tag, String arg, String val) {


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
                "var bs = document.getElementsByTagName('" + tag + "');\n" +
                " \n" +
                "function ss(){\n" +
                "for(i = 0;i < bs.length;i++){\n" +
                "   if(bs[i]." + arg + " == '" + val + "'){\n" +
//                "\treturn getElementViewLeft(bs[i]) + '_'+ getElementViewTop(bs[i]);\n" +
                "if(bs[i].value == '')\n" +
                "return getElementViewLeft(bs[i]) + '_'+ getElementViewTop(bs[i]);\n" +
                "else \n" +
                "return '@'+bs[i].value;\n" +
                "}" +
                "}\n" +
                "return '0';\n" +
                "}\n" +
                "ss();";

        return dd;
    }



//    public static String clickNameJs(String name) {
//
//
//        String dd = "javascript:function getElementViewLeft(element){\n" +
//                "　　　　var actualLeft = element.offsetLeft;\n" +
//                "　　　　var current = element.offsetParent;\n" +
//                "\n" +
//                "　　　　while (current !== null){\n" +
//                "　　　　　　actualLeft += current.offsetLeft;\n" +
//                "　　　　　　current = current.offsetParent;\n" +
//                "　　　　}\n" +
//                "\n" +
//                "　　　　if (document.compatMode == \"BackCompat\"){\n" +
//                "　　　　　　var elementScrollLeft=document.body.scrollLeft;\n" +
//                "　　　　} else {\n" +
//                "　　　　　　var elementScrollLeft=document.documentElement.scrollLeft;\n" +
//                "　　　　}\n" +
//                "\n" +
//                "　　　　return document.body.clientWidth +'_'+(actualLeft-elementScrollLeft);\n" +
//                "　　}\n" +
//                "\n" +
//                "function getElementViewTop(element){\n" +
//                "　　　　var actualTop = element.offsetTop;\n" +
//                "　　　　var current = element.offsetParent;\n" +
//                "\n" +
//                "　　　　while (current !== null){\n" +
//                "　　　　　　actualTop += current. offsetTop;\n" +
//                "　　　　　　current = current.offsetParent;\n" +
//                "　　　　}\n" +
//                "\n" +
//                "　　　　 if (document.compatMode == \"BackCompat\"){\n" +
//                "　　　　　　var elementScrollTop=document.body.scrollTop;\n" +
//                "　　　　} else {\n" +
//                "　　　　　　var elementScrollTop=document.documentElement.scrollTop;\n" +
//                "　　　　}\n" +
//                "\n" +
//                "　　　　return document.body.clientHeight +'_'+(actualTop-elementScrollTop);\n" +
//                "　　}" +
//                "" +
//                "var bs = document.getElementsByTagName('input');" +
//                "" +
//                "function ss(){" +
//                "for(i = 0;i < bs.length;i++){\n" +
//                "   if(bs[i].id == '" + name + "'){\n" +
//                "if(bs[i].value == '')" +
//                "return getElementViewLeft(bs[i]) + '_'+ getElementViewTop(bs[i]);\n" +
//                "else \n" +
//                "return '@'+bs[i].value;\n" +
//
//                "}\n" +
//
//                "}" +
//
//
//                "}\n" +
//
//                "ss();";
//
//
//////获取元素的纵坐标
////        function getTop(e){
////                var offset=e.offsetTop;
////        if(e.offsetParent!=null) offset+=getTop(e.offsetParent);
////        return offset;
////}
//////获取元素的横坐标
////        function getLeft(e){
////                var offset=e.offsetLeft;
////        if(e.offsetParent!=null) offset+=getLeft(e.offsetParent);
////        return offset;
////}
//
//        String ddc = "javascript:" +
//                "function getTop(e){\n" +
//                "                var offset=e.offsetTop;\n" +
//                "        if(e.offsetParent!=null) offset+=getTop(e.offsetParent);\n" +
//                "        return offset;\n" +
//                "}" +
//                "" +
//                "\n" +
//                "function getLeft(e){\n" +
//                "                var offset=e.offsetLeft;\n" +
//                "        if(e.offsetParent!=null) offset+=getLeft(e.offsetParent);\n" +
//                "        return offset;\n" +
//                "}" +
//                "var bs = document.getElementsByTagName('input');\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\nfunction dd( ){" +
//                "return getLeft(bs[0])+'   '+getTop(bs[0]) ;" +
//                "" +
//                "" +
//                "" +
//                "}\n" +
//                "dd();" +
//                "";
//
//        return dd;
//    }


}
