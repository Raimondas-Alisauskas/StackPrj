<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.TopicBin" %>
<%@ page import="controllers.ArticleController" %>
<html>
<head>
</head>
<jsp:useBean id="search" class="models.Search"
             scope="request"></jsp:useBean>

<body>

<div class="middle">
    <form action="article" method="get">
        <% ArrayList<TopicBin> topics = (ArrayList) request.getAttribute("Topics");
            for (TopicBin topic : topics) { %>
        <div class="article">
            <div>
                <Input type="hidden" name="id" id="id" value="<%=topic.getId()%>">
                <Input type="hidden" name="title" id="title" value="<%=topic.getTitle()%>">
                <%--<button type="submit"><%=topic.getTitle()%></button>--%>
                <a href="article?title=<%=topic.getTitle()%>" name="article_name"><h2><%=topic.getTitle()%>
                </h2></a>
            </div>
        </div>
    </form>
    <% } %>

</div>
<pre><code>using StackExchange.Redis;

// ...

// connect to the server
ConnectionMultiplexer connection = ConnectionMultiplexer.Connect(&quot;localhost&quot;);

// select a database (by default, DB = 0)
IDatabase db = connection.GetDatabase();

// run a command, in this case a GET
RedisValue myVal = db.StringGet(&quot;mykey&quot;);
</code></pre>
</body>
</html>
