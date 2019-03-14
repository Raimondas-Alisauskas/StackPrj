<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.beans.ArticleBean" %>
<%@ page import="model.DTO.ArticleDTO" %>
<%@ page import="java.util.List" %>
<html>
    <% ArticleDTO articleDTO = (ArticleDTO) request.getAttribute("articleDTO");%>

    <head>
        <title><%=articleDTO.getTabName()%> - <%=articleDTO.getTitle()%></title>
    </head>

    <body>
        <button type="button" class="btn btn-outline-info"
                onclick="history.back()">Neimantas feature
        </button>

        <div>
            <h1 class="text-center"><%=articleDTO.getTitle()%></h1>
        </div>

        <div class="accordion" id="accordionTitle">
            <% String introductionHtml = articleDTO.getIntroductionHtml();
                if (!introductionHtml.isEmpty()) {
            %>
            <div class="card">
                <div class="card-header" id="headingIntroduction">
                    <h2 class="mb-0">
                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseIntroduction"
                                aria-expanded="true" aria-controls="collapseIntroduction">
                            Introduction
                        </button>
                        <button type="button " class="btn btn-primary float-right" data-toggle="modal" data-target="#modifyModal">
                            Modify
                        </button>
                    </h2>
                </div>

                <div id="collapseIntroduction" class="collapse show" aria-labelledby="headingIntroduction" data-parent="#accordionTitle">
                    <div class="card-body">
                            <div><%=introductionHtml%></>

                    </div>



                    <div class="modal fade" id="modifyModal" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog modal-lg" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Modify</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form action ="article" method="post">
                                    <input type="hidden" name="id" value="<%=articleDTO.getId()%>">
                                    <input type="hidden" name="field" value="introductionHtml">
                                    <div class="modal-body" >
                                            <textarea class="form-control" name="updText" style = "height: 50vh">
                                                <%=introductionHtml%>
                                            </textarea>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Save changes</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>






                </div>
            </div>
            <%
                }
            %>

            <% String remarksHtml = articleDTO.getRemarksHtml();
                if (!remarksHtml.isEmpty()) {
            %>
            <div class="card">
                <div class="card-header" id="headingRemarks">
                    <h2 class="mb-0">
                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseRemarks"
                                aria-expanded="true" aria-controls="collapseRemarks">
                            Remarks
                        </button>
                    </h2>
                </div>

                <div id="collapseRemarks" class="collapse show" aria-labelledby="headingRemarks" data-parent="#accordionTitle">
                    <div class="card-body">
                        <%=remarksHtml%>
                    </div>
                </div>
            </div>
            <%
                }
            %>

            <% String parametersHtml = articleDTO.getParametersHtml();
                if (!parametersHtml.isEmpty()) {
            %>
            <div class="card">
                <div class="card-header" id="headingParameters">
                    <h2 class="mb-0">
                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseParameters"
                                aria-expanded="true" aria-controls="collapseParameters">
                            Parameters
                        </button>
                    </h2>
                </div>

                <div id="collapseParameters" class="collapse show" aria-labelledby="headingParameters" data-parent="#accordionTitle">
                    <div class="card-body">
                        <%=parametersHtml%>
                    </div>
                </div>
            </div>
            <%
                }
            %>

            <% String syntaxHtml = articleDTO.getSyntaxHtml();
                if (!syntaxHtml.isEmpty()) {
            %>
            <div class="card">
                <div class="card-header" id="headingSyntax">
                    <h2 class="mb-0">
                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseSyntax"
                                aria-expanded="true" aria-controls="collapseSyntax">
                            Syntax
                        </button>
                    </h2>
                </div>

                <div id="collapseSyntax" class="collapse show" aria-labelledby="headingSyntax" data-parent="#accordionTitle">
                    <div class="card-body">
                        <%=syntaxHtml%>
                    </div>
                </div>
            </div>
            <%
                }
            %>
        </div>

        <div>
            <h2 class="text-center">Examples</h2>
        </div>

        <div class="accordion" id="accordionExamples">
            <% List<ArticleBean> articles = articleDTO.getArticleList();%>
            <% int i = 0;%>
            <%for (ArticleBean article : articles) { %>
            <div class="card">
                <div class="card-header" id=<%="heading_" + i%>>
                    <h2 class="mb-0">
                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target=<%="#collapse_" + i%>
                                aria-expanded="false" aria-controls=<%="collapse_" + i%>>
                            <%=article.getTitle()%>
                        </button>
                    </h2>
                </div>

                <div id=<%="collapse_" + i%> class="collapse" aria-labelledby=<%="heading_" + i%> data-parent="#accordionExamples">
                    <div class="card-body">
                        <%=article.getExample()%>
                    </div>
                </div>
            </div>
            <% i++; %>
            <% } %>
        </div>

    </body>

</html>