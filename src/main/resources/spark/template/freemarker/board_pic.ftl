<!DOCTYPE html>
<?php session_start(); ?>
<html lang="en" >
    <head>
        <meta charset="utf-8" />
        <meta name="author" content="Script Tutorials" />
        <title>Board_Picture</title>

        <!-- add styles -->
        <link href="css/main.css" rel="stylesheet" type="text/css" />
		<link href="css/colorbox.css" rel="stylesheet" type="text/css" />
        <!-- add scripts -->
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.masonry.min.js"></script>
		<script src="js/jquery.colorbox-min.js"></script>
        <script src="js/script.js"></script>
    </head>
    <body>
	
		
		<script>
            jQuery(document).ready(function () {
                jQuery('a.gallery').colorbox({ opacity:0.5 , rel:'group1' });
            });
        </script>

        <!-- header panel -->
        <div class="header_panel">

            <!-- logo -->
            <a href="index.php" class="logo"></a>

            <!-- search form -->
            <form action="" method="get" class="search"> <!--action for the search result page-->
                <input autocomplete="off" name="q" size="27" placeholder="Search" type="text" />
                <input name="search" type="submit" />
            </form>

            <!-- navigation menu -->
            <ul class="nav">
                
                <li>
                    <a href="#">Add<span></span></a>
                    <ul>
                        <li><a class="gallery" href="web.php">From Website</a></li>
                        <li><a class="gallery" href="local.php">Upload</a></li>
                        
                    </ul>
                </li>
                <li>
                    <a href="#">Profile<span></span></a>
                    <ul>
                        <li><a href="#">Invite Friends</a></li>
                        <li><a href="friend.php">Find Friends</a></li>
                        <li class="div"><a href="board.php">Boards</a></li>
                        <li><a href="showpin.php">Pins</a></li>
                        <li><a href="showlike.php">Likes</a></li>
                        <li class="div"><a href="#">Settings</a></li>
                        <li><a href="logout.php">Logout</a></li>
                    </ul>
                </li>
                
            </ul>

        </div>

			
		
        <h2 class="pname">Wish List</h2>
		
		
        <!-- main container -->
        <div class="main_container">
			
		<#list records as record>
			<tr>
 				<td>${record.getWishCardID()}</td>
  				<td><a href="/print/${record.getWishCardID()}">${record.getFirstName()}</a></td>
  				<td>${record.getCardGender()}</td>
  				<td>${record.getCardAge()}</td>
  				<td>${record.getPreamble()}</td>
  				<td>${record.getGiftDescription() }</td>
  				<td>${record.getGift2Description() }</td>
     		</tr>
		<div class="pin">
			<div class="holder">
				<div class="actions" pic_id="1">
					
					<p>
						<font size="3" face="Verdana"> ${record.getFirstName()}</font>
					</p>

				</div> <!-- user name -->
				<a class="image" href="/card/index copy.html">
				<!--
                <img src="{$local}" />
				-->
				<img src = http://localhost:8888/wishcard/picture/QRCode.png
				</a>
		    </div>
		    <p class="desc">{record.getGiftDescription() },${record.getGift2Description() }</p> <!-- wish -->

        </div>

     	</#list>
        
     
    </body>
</html>