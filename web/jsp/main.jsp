<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.TopicBin" %>
<html>
<head>
</head>
<jsp:useBean id="search" class="models.Search"
             scope="request"></jsp:useBean>

<body>

<div class="middle">
    <% ArrayList<TopicBin> topics = (ArrayList) request.getAttribute("Topics");
        for (TopicBin topic : topics) { %>
    <div class="article">
        <div>
            <a href="#" name="article_name"><h2><%=topic.getTitle()%>
            </h2></a>
        </div>
        <div>
            <p><%="Cia bus tekstas arba nebus :)"%>
            </p>
        </div>
    </div>
    <% } %>

</div>

=======
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
>>>>>>> 0730cff21551fbcfc576ed3cc3f80e53433be7d4
</body>
</html>
