<%@ page import="DTO.TopicDTO" %>
<%@ page import="utils.ConfigurationProperties" %>
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
    <div class="footer">
        <div id="container">
            <div class="pagination">
                <% if(pageNumb > 1 ){%>
                    <a
                        href="<%=request.getContextPath()%>/?tagId=<%=tagId%>&search_field=<%=searchInput%>&pageNum=<%=pageNumb-1%>"
                       class="page">Previous
                    </a>
                <% } %>
                <span
                    class="page">
                    <%=pageNumb%> of <%=numbOfRecords / numberOfTitles + 1%>
                </span>
                <% if(pageNumb <= numbOfRecords / numberOfTitles){%>
                <a
                    href="<%=request.getContextPath()%>/?tagId=<%=tagId%>&search_field=<%=searchInput%>&pageNum=<%=pageNumb+1%>"
                    class="page">Next
                </a>
                <% } %>
              </div>
        </div>
    </div>
</body>
</html>
