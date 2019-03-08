<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.beans.TopicBean" %>
<%@ page import="controller.ArticleController" %>
<%@ page import="model.DTO.TopicDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="utils.constants.ErrorType" %>
<html>
<head>
    <% TopicDTO topicDTO = (TopicDTO) request.getAttribute("topicDTO");%>
</head>

<body>
    <div class="card-body">
        <div class="list-group">
           <% if(topicDTO.getErrorDTO() != null && topicDTO.getErrorDTO().isError){
                %><p class ="list-group-item bg-info text-white"> <%=topicDTO.getErrorDTO().message%> </p><%
            }else{%>

            <% List<TopicBean> topics = topicDTO.getTopicsList();
                for (TopicBean topic : topics) { %>
                    <a class="list-group-item list-group-item-action" href="article?id=<%=topic.getId()%>" name="article_name"><%=topic.getTitle()%>
                    </a>
                <% }%>
         <% }%>

        </div>
    </div>
</body>
</html>