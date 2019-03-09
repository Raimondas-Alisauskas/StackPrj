<%@ page import="model.DTO.TopicDTO" %>
<%@ page import="utils.properties.ConfigurationProperties" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        TopicDTO topicDTO = (TopicDTO) request.getAttribute("topicDTO");
        String tagId = topicDTO.getTagId();
        String searchInput = topicDTO.getSearchInput();
        int numbOfRecords = topicDTO.getNumbOfRecords();
        int pageNumb = topicDTO.getPageNumb();
        int numberOfTitles = ConfigurationProperties.SHOW_NUMB_OF_TITLES;
    %>
</head>
<body>

<div class="card-footer">

    <ul class="pagination justify-content-center">
        <li class="page-item
        <% if(pageNumb < 2 ){%>disabled<% } %>
        ">
            <a class="page-link"
               href="<%=request.getContextPath()%>/search?tagId=<%=tagId%>&search_field=<%=searchInput%>&pageNum=<%=pageNumb-1%>"
               aria-label="Previous"
            >
            <span aria-hidden="true">&laquo;</span>
            <span class="sr-only">Previous</span>
            </a>
        </li>
        <li class="page-item disabled">
            <span class="page-link ">
                <%=pageNumb%> of <%=numbOfRecords / numberOfTitles + 1%>
            </span>
        </li>
        <li class="page-item
                <% if(pageNumb > numbOfRecords / numberOfTitles){%>disabled<% } %>
        ">
            <a class="page-link"
               href="<%=request.getContextPath()%>/search?tagId=<%=tagId%>&search_field=<%=searchInput%>&pageNum=<%=pageNumb+1%>"
               aria-label="Next"
            >
            <span aria-hidden="true">&raquo;</span>
            <span class="sr-only">Next</span>
            </a>
        </li>
    </ul>

</div>

</body>
</html>
