<form  method='POST' action='/update'>
WishCardID: <input type="text" name="WCID">
			<input type = "submit" value = "finish">
		
       
</form>
 	
 	<table border="8">
 		<tr>
 			<td>WishCardID</td>
 			<td>Name</td>
 			<td>Gender</td>
 			<td>Age</td>
 			<td>Preamble</td>
 			<td>Gift1</td>
 			<td>Gift2</td>
 		</tr>
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
     	</#list>
	</table>
 	
 	
