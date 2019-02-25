<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Result" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        List<Result> results = (ArrayList) request.getAttribute("results");
        int pageNumb = results.get(0).getPageNumb();
        int getNumbOfRecords = results.get(0).getNumbOfRecords();
        String searchInput =results.get(0).getSearchInput();
    %>
</head>
<body>
    <div class="footer">
        <div id="container">
            <div class="pagination">
                <% if(pageNumb > 1 ){%>
                    <a
                        href="<%=request.getContextPath()%>/result?lang_name=android&search_field=<%=searchInput%>&pageNum=<%=pageNumb-1%>"
                       class="page">Previos
                    </a>
                <% } %>
                <span
                    class="page">
                    <%=pageNumb%>
                </span>
                <% if(pageNumb <= getNumbOfRecords/10 ){%>
                <a
                    href="<%=request.getContextPath()%>/result?lang_name=android&search_field=<%=searchInput%>&pageNum=<%=pageNumb+1%>"
                    class="page">Next
                </a>
                <% } %>
              </div>
        </div>
    </div>
</body>
</html>
