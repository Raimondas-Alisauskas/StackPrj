<%@ page import="model.beans.DropdownBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.DTO.TopicDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        TopicDTO topicDTO = (TopicDTO) request.getAttribute("topicDTO");
        String tagId = topicDTO.getTagId();
        String searchInput = topicDTO.getSearchInput();
        ArrayList<DropdownBean> tagList = (ArrayList) session.getAttribute("tagList");
    %>
</head>
<body>

<div class="card-header">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand " href="<%=request.getContextPath()%>/welcome">
            <img src="<%=request.getContextPath()%>/images/stack_Overflow_logo.png" ;
                 height="30" alt="">
        </a>
        <button class="navbar-toggler mb-1" type="button" data-toggle="collapse" data-target="#navbarToggler"
                aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse row" id="navbarToggler">
            <form class="input-group mb-0 w-75" action="search" method="get">
                <div class="col-3">
                    <select class="custom-select" id="lang" name="tagId">
                        <option selected value="">Select a Tag</option>
                        <% for (DropdownBean tag : tagList) { %>
                        <option value="<%=tag.getId()%>" <% if (tagId.equals(tag.getId())) {%>
                                selected<%}%>
                        >
                            <%=tag.getTag()%>
                        </option>
                        <% } %>
                    </select>
                </div>
                <div class="col-5">
                    <input type="text" class="form-control" placeholder="Search.." name="search_field"
                           value="<%=searchInput%>">
                </div>
                <div class="col-2 d-flex justify-content-end">
                    <button class="btn btn-primary" type="submit">Search</button>
                </div>
            </form>
            <div class="input-group w-25 pl-4">
                <div class="d-flex">
                    <button type="button" class="btn btn-outline-success">Log In</button>
                </div>
                <div class="d-flex pl-4">
                    <button type="button" class="btn btn-success">Sign Up</button>
                </div>
            </div>
        </div>
    </nav>
</div>
</body>
</html>

