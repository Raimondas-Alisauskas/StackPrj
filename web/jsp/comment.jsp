<%--
  Created by IntelliJ IDEA.
  User: Vartotojas
  Date: 12-Mar-19
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comment</title>
</head>
<body>
<hr width="6">
<div>
    <div class="form">

        <div class="card">
            <div class="card-header" id="headingIntroduction">
                <h2 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse"
                            data-target="#collapseIntroduction"
                            aria-expanded="false" aria-controls="collapseIntroduction">
                        Comments
                    </button>
                </h2>
            </div>

            <div id="collapseIntroduction" class="collapse" aria-labelledby="headingIntroduction"
                 data-parent="#accordionTitle">
                <div class="card-body">
                    <form action="/html/tags/html_form_tag_action.cfm" method="post">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea3"></label>
                            <textarea class="form-control" id="exampleFormControlTextarea3" rows="12" placeholder="
                Leave a comment here...
             "></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
