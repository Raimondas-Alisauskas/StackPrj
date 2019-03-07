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
               href="<%=request.getContextPath()%>/?tagId=<%=tagId%>&search_field=<%=searchInput%>&pageNum=<%=pageNumb-1%>"
            >Previous</a>
        </li>
        <li class="page-item">
            <span class="page-link">
                <%=pageNumb%> of <%=numbOfRecords / numberOfTitles + 1%>
            </span>
        </li>
        <li class="page-item
                <% if(pageNumb > numbOfRecords / numberOfTitles){%>disabled<% } %>
        ">
            <a class="page-link" href="<%=request.getContextPath()%>/?tagId=<%=tagId%>&search_field=<%=searchInput%>&pageNum=<%=pageNumb+1%>">Next</a>
        </li>
    </ul>

</div>





    <%--<div class="footer">--%>
        <%--<div id="container">--%>
            <%--<div class="pagination">--%>
                <%--<% if(pageNumb > 1 ){%>--%>
                    <%--<a--%>
                        <%--href="<%=request.getContextPath()%>/?tagId=<%=tagId%>&search_field=<%=searchInput%>&pageNum=<%=pageNumb-1%>"--%>
                       <%--class="page">Previous--%>
                    <%--</a>--%>
                <%--<% } %>--%>
                <%--<span--%>
                    <%--class="page">--%>
                    <%--<%=pageNumb%> of <%=numbOfRecords / numberOfTitles + 1%>--%>
                <%--</span>--%>
                <%--<% if(pageNumb <= numbOfRecords / numberOfTitles){%>--%>
                <%--<a--%>
                    <%--href="<%=request.getContextPath()%>/?tagId=<%=tagId%>&search_field=<%=searchInput%>&pageNum=<%=pageNumb+1%>"--%>
                    <%--class="page">Next--%>
                <%--</a>--%>
                <%--<% } %>--%>
              <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
</body>
</html>
