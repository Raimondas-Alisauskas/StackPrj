
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comments</title>
    <link rel="stylesheet" type="text/css" href="style/styles.css">
</head>
<body>
<div>
    <h2 class="text-center">Commentary</h2>
</div>
<div>
    <div class="form">

        <div class="card">
            <div class="card-header" id="headingIntroduction">
                <h2 class="mb-0">
                    <button class="btn btn-link" type="button" data-toggle="collapse"
                            data-target="#collapseIntroduction"
                            aria-expanded="false" aria-controls="collapseIntroduction">
                        Show comments
                    </button>
                </h2>
            </div>

            <div id="collapseIntroduction" class="collapse" aria-labelledby="headingIntroduction"
                 data-parent="#accordionTitle">
                <div class="card-body">
                    <form action="" method="post">
                        <div class="form-group">
                            <label for="exampleFormControlTextarea3"></label>
                            <textarea class="form-control" id="exampleFormControlTextarea3" rows="12" placeholder="
                Leave a comment here...
             "></textarea>
                        </div>
                        <button type="submit" class="btn btn-info">Submit</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
