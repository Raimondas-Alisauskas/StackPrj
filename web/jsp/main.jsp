<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<jsp:useBean id="search" class="models.Search"
             scope="request"></jsp:useBean>
<body>
<div class="middle">

    <div class="article">
        <div>
            <a href="#" name="article_name"><h2><%=request.getParameter("lang_name")%>
            </h2></a>
        </div>
        <div>
            <p><%=request.getParameter("search_field")%>
            </p>
        </div>
    </div>
    <div class="article">
        <div>
            <a href="#" name="article_name"><h2>Title</h2></a>
        </div>
        <div>
            <p>18-Feb-2019 21:30:59.414 INFOfig.deployDirectory Deploying web </p>
        </div>
    </div>
    <div class="article">
        <div>
            <a href="#" name="article_name"><h2>Title</h2></a>
        </div>
        <div>
            <p>18-Feb-2019 21:30:59.414 INFOfig.deployDirectory Deploying web </p>
        </div>
    </div>
    <div class="article">
        <div>
            <a href="#" name="article_name"><h2>Title</h2></a>
        </div>
        <div>
            <p>18-Feb-2019 21:30:59.414 INFOfig.deployDirectory Deploying web </p>
        </div>
    </div>
    <div class="article">
        <div>
            <a href="#" name="article_name"><h2>Title</h2></a>
        </div>
        <div>
            <p>18-Feb-2019 21:30:59.414 INFOfig.deployDirectory Deploying web </p>
        </div>
    </div>
    <div class="article">
        <div>
            <a href="#" name="article_name"><h2>Title</h2></a>
        </div>
        <div>
            <p>18-Feb-2019 21:30:59.414 INFOfig.deployDirectory Deploying web </p>
        </div>
    </div>
</div>
</body>
</html>
