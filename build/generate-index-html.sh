#!/bin/sh

# based on https://odoepner.wordpress.com/2012/02/17/shell-script-to-generate-simple-index-html/

echo '<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IBM Cloud My Services</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>IBM Cloud My Services Java SDK Documentation</h1>
    </div>

    <p><a href="https://cloud.ibm.com/apidocs?category=<service-category>">My Services Info</a>
        | <a href="<github-repo-url">GitHub</a>
    </p>

    <p>Javadoc by branch/release:</p>
    <ul><li><a href="docs/latest">Latest</a></li>'
ls docs | grep --invert-match index.html | sed 's/^.*/<li><a href="docs\/&">&<\/a><\/li>/'
echo '    </ul>
</div>
<script>
    (function(i,s,o,g,r,a,m){i["GoogleAnalyticsObject"]=r;i[r]=i[r]||function(){
                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,"script","//www.google-analytics.com/analytics.js","ga");
    ga("create", "UA-59827755-4", "auto");
    ga("send", "pageview");
</script>
</body>
</html>'
