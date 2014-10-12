<!DOCTYPE html>
<?php session_start(); ?>
<html lang="en" >
    <head>
        <meta charset="utf-8" />
        <meta name="author" content="Script Tutorials" />
        <title>Board_Picture</title>

        <!-- add styles -->
        <link href="/static/css/main.css" rel="stylesheet" type="text/css" />
		<link href="/static/css/colorbox.css" rel="stylesheet" type="text/css" />
        <!-- add scripts -->
        <script src="/static/js/jquery.min.js"></script>
        <script src="/static/js/jquery.masonry.min.js"></script>
		<script src="/static/js/jquery.colorbox-min.js"></script>
        <script src="/static/js/script.js"></script>
    </head>
    <body>
	
		
		<script>
            jQuery(document).ready(function () {
                jQuery('a.gallery').colorbox({ opacity:0.5 , rel:'group1' });
            });
        </script>

        <!-- header panel -->
        
<form method='POST' action="/read">

			gender: <select name = "gender">
						<option value ="all">all</option>
  						<option value ="boy">boy</option>
  						<option value ="girl">girl</option>
					</select>
			gift: <input type = "text" name = gift>
					<select name = "searchFilter">
  						<option value =0>Pending</option>
  						<option value =1>Done</option>
					</select>
				  <input type = "submit">
       
</form>


           

        

			
		
        <h2 class="pname">Wish List</h2>
		
		
        <!-- main container -->
        <div class="main_container">
			
		<#list records as record>
			
		<div class="pin">
		
			<p>
				<font size="3" face="Verdana"> ${record.getFirstName()}</font>
			</p>
			
			<div class="holder">
				<div class="actions" pic_id="1">

				</div> <!-- user name -->
				<a target="_blank" class="image" href="/print/${record.getWishCardID()}">
				<!--
                <img src="{$local}" />
				-->
				<img  src = "${record.getPicAddress()}"></img>
				</a>
		    </div>
		    <p class="desc">${record.getGiftDescription() },${record.getGift2Description() }</p> <!-- wish -->

        </div>

     	</#list>
        
     
    </body>
</html>