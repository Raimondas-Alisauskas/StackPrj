<%@ page import="models.TopicResults" %>
<%@ page import="utils.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        TopicResults topicResults = (TopicResults) request.getAttribute("topicResults");
        int tagId = topicResults.getTagId();
        String searchInput = topicResults.getSearchInput();
        int numbOfRecords = topicResults.getNumbOfRecords();
        int pageNumb = topicResults.getPageNumb();
        int numberOfTitles = Constants.SHOW_NUMB_OF_TITLES;
    %>
</head>
<body>
    <div class="footer">
        <div id="container">
            <div class="pagination">
                <% if(pageNumb > 1 ){%>
                    <a
                        href="<%=request.getContextPath()%>/?tagId=<%=tagId%>&search_field=<%=searchInput%>&pageNum=<%=pageNumb-1%>"
                       class="page">Previos
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
