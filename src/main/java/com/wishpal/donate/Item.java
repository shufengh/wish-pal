package com.wishpal.donate;

public class Item {
	
	public int WishCardID;
	public String AgencyCode;
	public int AgencyZone;
	public int AgencyChildID;
	public String FirstName;
	public String CardGender;
	public String CardAge;
	public String SpecialNeed;
	public String Preamble;
	public String GiftID;
	public String GiftDescription;
	public String GiftAttribute1;
	public String ReceiptNotice;
	public String Gift2Description;
	public String picAddress;
//	public Item(int WCID, String AC, int AZ, int ACID, String FN, String CG){
//		this.WishCardID = WCID;
//		this.AgencyCode = AC;
//		this.AgencyZone = AZ;
//		this.AgencyChildID = ACID;
//		this.FirstName = FN;
//		this.CardGender = CG;
//		
//	}
	public Item(int WCID, String FN, String CG, String CA, String Pre, String GD, String G2D){
		this.WishCardID = WCID;
		this.FirstName = FN;
		this.CardGender = CG;
		this.CardAge = CA;
		this.Preamble = Pre;
		this.GiftDescription = GD;
		this.Gift2Description = G2D;
		
	}
	
	public Item(int WCID, String AC, int AZ, int ACID, String FN, String CG, String CA, 
			String SN, String Pre, String GID, String GD, String GA, String RN, String G2N){
		
		this.WishCardID = WCID;
		this.AgencyCode = AC;
		this.AgencyZone = AZ;
		this.AgencyChildID = ACID;
		this.FirstName = FN;
		this.CardGender = CG;
		this.CardAge = CA;
		this.SpecialNeed = SN;
		this.Preamble = Pre;
		this.GiftID = GID;
		this.GiftDescription = GD;
		this.GiftAttribute1 = GA;
		this.ReceiptNotice = RN;
		this.Gift2Description = G2N;
		
		
	}

	public int getWishCardID() {
		return WishCardID;
	}

	public void setWishCardID(int wishCardID) {
		WishCardID = wishCardID;
	}

	public String getAgencyCode() {
		return AgencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		AgencyCode = agencyCode;
	}

	public int getAgencyZone() {
		return AgencyZone;
	}

	public void setAgencyZone(int agencyZone) {
		AgencyZone = agencyZone;
	}

	public int getAgencyChildID() {
		return AgencyChildID;
	}

	public void setAgencyChildID(int agencyChildID) {
		AgencyChildID = agencyChildID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getCardGender() {
		return CardGender;
	}

	public void setCardGender(String cardGender) {
		CardGender = cardGender;
	}

	public String getCardAge() {
		return CardAge;
	}

	public void setCardAge(String cardAge) {
		CardAge = cardAge;
	}

	public String getSpecialNeed() {
		return SpecialNeed;
	}

	public void setSpecialNeed(String specialNeed) {
		SpecialNeed = specialNeed;
	}

	public String getPreamble() {
		return Preamble;
	}

	public void setPreamble(String preamble) {
		Preamble = preamble;
	}

	public String getGiftID() {
		return GiftID;
	}

	public void setGiftID(String giftID) {
		GiftID = giftID;
	}

	public String getGiftDescription() {
		return GiftDescription;
	}

	public void setGiftDescription(String giftDescription) {
		GiftDescription = giftDescription;
	}

	public String getGiftAttribute1() {
		return GiftAttribute1;
	}

	public void setGiftAttribute1(String giftAttribute1) {
		GiftAttribute1 = giftAttribute1;
	}

	public String getReceiptNotice() {
		return ReceiptNotice;
	}

	public void setReceiptNotice(String receiptNotice) {
		ReceiptNotice = receiptNotice;
	}

	public String getGift2Description() {
		return Gift2Description;
	}

	public void setGift2Description(String gift2Description) {
		Gift2Description = gift2Description;
	}

	public String getPicAddress() {
		return picAddress;
	}

	public void setPicAddress(String picAddress) {
		this.picAddress = picAddress;
	}
	

}
