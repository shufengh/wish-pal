<!--
@version   1.0 | December 20, 2011
@author    Mihai Balea http://www.mihaibalea.info | http://www.templatesbook.com
@copyright Copyright (C) 2012 TemplatesBook
@license   http://www.gnu.org/licenses/gpl-2.0.html GNU/GPLv2 only
-->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="Lang" content="en"/>
<meta name="author" content="Mihai Balea"/>
<meta http-equiv="Reply-to" content="contact@mihaibalea.info"/>

<title>John Doe | Personal Portfolio</title>

<link id="mainCSS" rel="stylesheet" type="text/css" href="/static/wishCard/css/style.css"/>
<link id="mainCSS" rel="stylesheet" type="text/css" href="/static/wishCard/css/skins.css"/>
<link rel="stylesheet" type="text/css" href="/static/wishCard/css/skin.css" />

<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css' />

<script charset="utf-8" type="text/javascript" src="/static/wishCard/js/jquery.1.4.2.min.js"></script>
<script type= "text/javascript" src="/static/wishCard/js/queryLoader.js" ></script>
<script type="text/javascript" src="/static/wishCard/js/jquery.backgroundposition.js"></script>
<script type="text/javascript" src="/static/wishCard/js/jquery.smooth-scroll.js"></script>
<script type="text/javascript" src="/static/wishCard/js/sp.js"></script>
<script type="text/javascript" src="/static/wishCard/js/js.js"></script>
<script type="text/javascript" src="/static/wishCard/js/skins.js"></script>

</head>

<body id="body_pat" class="red">
<div id="wrapper">
<!------------------------- TOOLS -->

    <div id="tools">
        <div id="but_expand">+</div>
        <div id="but_collapse">-</div>
        <span>SKINS</span>
        <div class="clear"></div>
        <div id="toolsHolder">
            <div id="palette">
                <div id="c_red" class="selected"></div>
                <div id="c_blue"></div>
                <div id="c_green"></div>
                <div id="c_pink"></div>
                <div id="c_orange"></div>
                <div id="c_gray"></div>
            </div>
            <div id="patterns">
                <div id="pat_1" class="selected"></div>
                <div id="pat_2"></div>
                <div id="pat_3"></div>
                <div id="pat_4"></div>
                <div id="pat_5"></div>
            </div>
        </div>
    </div><!-- end div #tools -->

<!------------------------- NAVIGATION -->

    <div id="navbarHolder">
        <div id="navbar">
            <ul>

                <li><a id="nav_about" href="#about">ABOUT<span class="m_w">ABOUT</span><span class="m_r">ABOUT</span></a></li>
                <li><a id="nav_work" href="#work">WORK<span class="m_w">WORK</span><span class="m_r">WORK</span></a></li>
                <li><a id="nav_projects" href="#projects">Projects<span class="m_w">Projects</span><span class="m_r">Projects</span></a></li>
                <li><a id="nav_contact" href="#contact">Contact<span class="m_w">Contact</span><span class="m_r">Contact</span></a></li>
            </ul>
        </div>
    </div><!-- end div #navbarHolder -->

<!------------------------- CONTENT -->

    <div id="container">
        <div id="logo" title="John Doe" class="site-message-absolute">
            <div class="nav_logo_w"></div>
        </div>

<!------------------------- ABOUT -->

        <div id="about">
            <a id="logo_big" title="John Doe" href="index.html"></a>
            <div id="headline" class="left grid">
                <h1>${record.getFirstName()}</h1><br />
                <h2><span>Age: ${record.getCardAge()}</span></h2><br />
                <h2><span>Gender: ${record.getCardGender()}</span></h2>
            </div>
            <div id="about_pict" class="grid"><img src="${codepic}" alt="Mihai Balea | Portfolio" /></div>
            <div class="clear">&nbsp;</div>
            <div class="left grid"></div>
            <div class="left grid about_text">
                <h2>Wish1: </h2><br />
				<p>
				    ${record.getGiftDescription() }
				</p>
            </div>
            <div class="right grid about_text">
                <h2>Wish2: </h2><br />
				<p>
					${record.getGift2Description() }
                <!--
					<ul>
					<li><strong>Adobe Creative Suite</strong></li>
					<li><strong>Web Standards &amp; Accessibility</strong></li>
					<li><strong>CSS/HTML</strong></li>
					<li><strong>PHP/MYSQL</strong></li>
					<li><strong>JQuery</strong></li>
					<li><strong>Wordpress</strong></li>
					</ul>
                -->
				</p>
            </div>
			<div class="clear"></div>
		</div><!-- end div #about -->



<!------------------------- WORK -->



    </div><!-- end div #container -->
</div><!-- end div #wrapper -->

<script type='/static/wishCard/text/javascript'>
    QueryLoader.init();
</script>

</body>
</html>

