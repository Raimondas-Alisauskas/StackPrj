<%@ page import="model.beans.DropdownBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.DTO.TopicDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style/styles.css">
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
                    <button class="btn btn-success" type="submit">Search</button>
                </div>
            </form>
            <div class="input-group w-25 pl-4">
                <div class="d-flex">
                    <a href="#logIn" class="trigger-btn" data-toggle="modal">
                        <button class="btn btn-outline-primary" data-toggle="modal">Log In</button>
                    </a>
                </div>
                <div class="d-flex pl-4">
                    <a href="#signUp" class="trigger-btn" data-toggle="modal">
                        <button type="button" class="btn btn-primary" data-toggle="modal">
                            Sign Up
                        </button>
                    </a>
                </div>
            </div>
            <div id="logIn" class="modal fade">
                <div class="modal-dialog modal-login">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">LOG IN</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="" method="post">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="email" placeholder="Email"
                                           required="required">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" name="password" placeholder="Password"
                                           required="required">
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-lg btn-block login-btn">LOG IN
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div id="signUp" class="modal fade">
                <div class="modal-dialog modal-login">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">SIGN UP</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form action="" method="post">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="regName" placeholder="Display name"
                                           required="required" maxlength="25">
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control" name="regEmail"
                                           placeholder="Email (required, but never shown)"
                                           required="required">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" name="regPassword" placeholder="Password"
                                           required="required">
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-lg btn-block login-btn">SIGN UP
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</div>
</body>
</html>

