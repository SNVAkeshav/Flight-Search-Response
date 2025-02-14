package com.reservationsdeal;
public class Results {
        //private String title;
        private String availableCurrencyOnWidget;
        private String tripSelection;
        private String fromWidget;
        private String toWidget;
        private String departDate;
        private String returnDateWidget;
        private String travelerAndClassOnWidget;
        private String currencyOnListing;
        private String listingTripType;
        private String fromOnListing;
        private String toOnListingPage;
        private String departShowing;
        private String returnShowing;
        private String departDateOnListing;
        private String returnDateOnListing;
        private String travelerAndClassOnListing;
        private String availableAirlinesOnListing;
//        private String firstPriceShowing;
        private String searchTime;
        
        // Setters for each result variable
//        public void setTitle(String title) {
//            this.title = title;
//        }
        public void setAvailableCurrencyOnWidget(String availableCurrencyOnWidget) {
        	this.availableCurrencyOnWidget = availableCurrencyOnWidget;
        }
        public void setTripSelection(String tripSelection) {
        	this.tripSelection = tripSelection;
        }
        public void setFromWidget(String fromWidget) {
            this.fromWidget = fromWidget;
        }
        public void setTOWidget(String toWidget) {
            this.toWidget = toWidget;
        }
        public void setDepartDate(String departDate) {
            this.departDate = departDate;
        }
        public void setReturnDateWidget(String returnDateWidget) {
            this.returnDateWidget = returnDateWidget;
        }
        public void setTravelerAndClassOnWidget(String travelerAndClassOnWidget) {
            this.travelerAndClassOnWidget = travelerAndClassOnWidget;
        }
        public void setCurrencyOnListing(String currencyOnListing) {
        	this.currencyOnListing = currencyOnListing;
        }
        public void setListingTripType(String listingTripType) {
        	this.listingTripType = listingTripType;
        }
        public void setFromOnListing(String fromOnListing) {
            this.fromOnListing = fromOnListing;
        }
        public void setToOnListingPage(String toOnListingPage) {
            this.toOnListingPage = toOnListingPage;
        }
        public void setDepartShowing(String departShowing) {
            this.departShowing = departShowing;
        }
        public void setReturnShowing(String returnShowing) {
            this.returnShowing = returnShowing;
        }
        public void setDepartDateOnListing(String departDateOnListing) {
            this.departDateOnListing = departDateOnListing;
        }
        public void setReturnDateOnListing(String returnDateOnListing) {
            this.returnDateOnListing = returnDateOnListing;
        }
        public void setTravelerAndClassOnListing(String travelerAndClassOnListing) {
            this.travelerAndClassOnListing = travelerAndClassOnListing;
        }
        public void setAvailableAirlinesOnListing(String availableAirlinesOnListing) {
        	this.availableAirlinesOnListing = availableAirlinesOnListing;
        }
//        public void setFirstPriceShowing(String firstPriceShowing) {
//        	this.firstPriceShowing = firstPriceShowing;
//        }
        public void setSearchTime(String searchTime) {
            this.searchTime = searchTime;
        }
        

        
        @Override
        public String toString() {
            return "<html>" +
                   "<head>" +
                   "<style>" +
                   "table { width: 100%; border-collapse: collapse; }" +
                   "th, td { padding: 8px; text-align: left; border: 1px solid #ddd; }" +
                   "th { background-color: #f8b50f; color: white; }" +
                   "@media screen and (max-width: 768px) {" + // For small screens
                   "  table { font-size: 12px; }" +
                   "  th, td { padding: 6px; }" +
                   "}" +
                   "@media screen and (min-width: 769px) {" + // For large screens
                   "  table { font-size: 16px; }" +
                   "  th, td { padding: 10px; }" +
                   "}" +
                   "</style>" +
                   "</head>" +
                   "<body>" +
                   "<table>" +
                   // Header Row
                   "<tr>" +
                   "<th>Page</th>" +
//                   "<th>Website Title</th>" +
                   "<th>Currency</th>" +
                   "<th>Trip Type</th>" +
                   "<th>From</th>" +
                   "<th>To</th>" +
                   "<th>Dep. Date</th>" +
                   "<th>Return Date</th>" +
                   "<th>Traveller(s) & Class</th>" +

                   "<th>Available Airlines</th>" +
//                   "<th>First Airline Price</th>" +
                   "<th>Search Time</th>" +
                   "</tr>" +

                   // Widget Row
                   "<tr>" +
                   "<th>Widget</th>" +
//                   "<td>" + title + "</td>" +
                   "<td>" + availableCurrencyOnWidget + "</td>" +
                   "<td>" + tripSelection + "</td>" +
                   "<td>" + fromWidget + "</td>" +
                   "<td>" + toWidget + "</td>" +
                   "<td>" + departDate + "</td>" +
                   "<td>" + returnDateWidget + "</td>" +
                   "<td>" + travelerAndClassOnWidget + "</td>" +

                   "<td style = 'text-align: center;'> NA </td>" + // Empty cells for Widget row
//                   "<td style = 'text-align: center;'> NA </td>"  +
                   "<td style = 'text-align: center;'> NA </td>"  +
                   "</tr>" +	

                   // Listing Row
                   "<tr>" +
                   "<th>Listing</th>" +
//                   "<td style = 'text-align: center;'> NA </td>" + // Empty cell for Website Title in Listing row
                   "<td>" + currencyOnListing + "</td>" +
                   "<td>" + listingTripType + "</td>" +
                   "<td>" + fromOnListing + "</td>" +
                   "<td>" + toOnListingPage + "</td>" +
                   "<td>" + departDateOnListing + "</td>" +
                   "<td>" + returnDateOnListing + "</td>" +
                   "<td>" + travelerAndClassOnListing + "</td>" +
                   "<td style='color:" + (availableAirlinesOnListing.equals("Flight not found") ? "red" : "black") + ";'>" + availableAirlinesOnListing.replaceAll("(\\d+\\.\\d+)", "<b>$1</b><br>") + "</td>" +
                   //"<td>" + availableAirlinesOnListing.replaceAll("(\\d+\\.\\d+)", "<b>$1</b><br>") + "</td>" +
//                   "<td>" + firstPriceShowing + "</td>" +
                   "<td>" + searchTime + " Sec</td>" +
                   "</tr>" +
                   "</table>" +
                   "</body>" +
                   "</html>";
        }
}