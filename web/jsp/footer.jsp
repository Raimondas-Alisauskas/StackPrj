<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        int numbOfRecords = (int) request.getAttribute("numbOfRecords");
        int pageNumb = (int) request.getAttribute("pageNumb");
        String searchInput = String.valueOf(request.getAttribute("searchInput"));
    %>
</head>
<body>
    <div class="footer">
        <div id="container">
            <div class="pagination">
                <% if(pageNumb > 1 ){%>
                    <a
                        href="<%=request.getContextPath()%>/?lang_name=android&search_field=<%=searchInput%>&pageNum=<%=pageNumb-1%>"
                       class="page">Previos
                    </a>
                <% } %>
                <span
                    class="page">
                    <%=pageNumb%> of <%=numbOfRecords /10 + 1%>
                </span>
                <% if(pageNumb <= numbOfRecords /10 ){%>
                <a
                    href="<%=request.getContextPath()%>/?lang_name=android&search_field=<%=searchInput%>&pageNum=<%=pageNumb+1%>"
                    class="page">Next
                </a>
                <% } %>
              </div>
        </div>
    </div>
</body>
</html>
