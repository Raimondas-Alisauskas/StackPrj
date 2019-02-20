<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 20-Feb-19
  Time: 01:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TEST DB</title>
</head>
<body>

<jsp:useBean id="TestBin" class="test.java.controlers.TestBin" scope="request"/>
<jsp:getProperty name="TestBin" property="field1"/>
<jsp:getProperty name="TestBin" property="field2"/>

</body>
</html>
