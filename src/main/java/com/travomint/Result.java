package com.travomint;

class Result {
        //private String title;
        private String availableCurrencyOnWidget;
        private String tripSelection;
        private String fromWidget;
        private String toWidget;
        private String calenderWidget;
        private String travelerWidget;
        private String currencyOnListing;
        private String listingTripType;
        private String fromOnListing;
        private String toOnListingPage;
        private String totalShowing;
        private String calenderModified;
        private String travelerModified;
        private String airlinespriceSymbol;
        private String firstPriceShowing;
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
        public void setCalenderWidget(String calenderWidget) {
            this.calenderWidget = calenderWidget;
        }
        public void setTravelerWidget(String travelerWidget) {
            this.travelerWidget = travelerWidget;
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
        public void setTotalShowing(String totalShowing) {
            this.totalShowing = totalShowing;
        }
        public void setCalenderModified(String calenderModified) {
            this.calenderModified = calenderModified;
        }
        public void settravelerModified(String travelerModified) {
            this.travelerModified = travelerModified;
        }
        public void setAirlinespriceSymbol(String airlinespriceSymbol) {
        	this.airlinespriceSymbol = airlinespriceSymbol;
        }
        public void setFirstPriceShowing(String firstPriceShowing) {
        	this.firstPriceShowing = firstPriceShowing;
        }
        public void setsearchTime(String searchTime) {
            this.searchTime = searchTime;
        }
        
        // Overriding toString method to print all results in one go
       // @Override
//        public String toString() {
//            return "<html>" +
//                   "<body>" +
//                   "<h2 style='color:blue;'>Input in Widget</h2>" +
//                   "<table border='1' style='border-collapse: collapse; width: 50%; text-align: left;'>" +
//                   "<tr><th style='background-color: lightgray;'>Field</th><th>Details</th></tr>" +
//                   "<tr><td><strong>Website Title</strong></td><td>" + title + "</td></tr>" +
//                   "<tr><td><strong>Widget -> From</strong></td><td>" + text1 + "</td></tr>" +
//                   "<tr><td><strong>Widget -> To</strong></td><td>" + fromWidget + "</td></tr>" +
//                   "<tr><td><strong>Date on Widget</strong></td><td>" + calenderWidget + "</td></tr>" +
//                   "<tr><td><strong>Traveler(s) & Class on Widget</strong></td><td>" + travelerWidget + "</td></tr>" +
//                   "</table>" +
//                   "<hr>" +
//                   "<h2 style='color:orange;'>Result on Listing</h2>" +
//                   "<table border='1' style='border-collapse: collapse; width: 50%; text-align: left;'>" +
//                   "<tr><th style='background-color: lightgray;'>Field</th><th>Details</th></tr>" +
//                   "<tr><td><strong>Listing -> From</strong></td><td>" + text2 + "</td></tr>" +
//                   "<tr><td><strong>Listing -> To</strong></td><td>" + fromDestination + "</td></tr>" +
//                   "<tr><td><strong>Search Response Time</strong></td><td>" + searchTime + " Seconds</td></tr>" +
//                   "<tr><td><strong>Total Flights Showing on Listing Page</strong></td>" +
//                   "<td style='color:" + (totalShowing.equals("Flight not found") ? "red" : "green") + ";'>" + totalShowing + "</td></tr>" +
//                   "<tr><td><strong>Date on Listing</strong></td><td>" + calenderModified + "</td></tr>" +
//                   "<tr><td><strong>Traveler(s) & Class on Listing</strong></td><td>" + travelerModified + "</td></tr>" +
//                   "</table>" +
//                   "<p style='color: gray;'>Best Regards,<br>" +
//                   "<strong>Keshav</strong><br>" +
//                   "</body>" +
//                   "</html>";
//        }
//
//    }
        
        //@Override
//        public String toString() {
//            return "<html>" +
//                   "<body>" +
//                   "<h2 style='color:blue;'>Widget</h2>" +
//                   "<table border='1' style='border-collapse: collapse; width: 100%; text-align: left;'>" +
//                   "<tr style='background-color: orange;'>" +
//                   "<th>Website Title</th>" +
//                   "<th>From</th>" +
//                   "<th>To</th>" +
//                   "<th>Date</th>" +
//                   "<th>Traveler(s) & Class</th>" +
//                   "</tr>" +
//                   "<tr>" +
//                   "<td>" + title + "</td>" +
//                   "<td>" + text1 + "</td>" +
//                   "<td>" + fromWidget + "</td>" +
//                   "<td>" + calenderWidget + "</td>" +
//                   "<td>" + travelerWidget + "</td>" +
//                   "</tr>" +
//                   "</table>" +
////                   "<hr>" +
//                   "<h2 style='color:blue;'>Listing</h2>" +
//                   "<table border='1' style='border-collapse: collapse; width: 100%; text-align: left;'>" +
//                   "<tr style='background-color: orange;'>" +
//                   "<th>From</th>" +
//                   "<th>To</th>" +
//                   "<th>Date</th>" +
//                   "<th>Traveler(s) & Class</th>" +
//                   "<th>Total Flights Showing</th>" +
//                   "<th>Search Response Time</th>" +
//                   "</tr>" +
//                   "<tr>" +
//                   "<td>" + text2 + "</td>" +
//                   "<td>" + fromDestination + "</td>" +
//                   "<td>" + calenderModified + "</td>" +
//                   "<td>" + travelerModified + "</td>" +
//                   "<td style='color:" + (totalShowing.equals("Flight not found") ? "red" : "green") + ";'>" + totalShowing + "</td>" +
//                   "<td>" + searchTime + " Seconds</td>" +
//                   "</tr>" +
//                   "</table>" +
//                   "<p style='color: gray;'>Best Regards,<br>" +
//                   "<strong>Keshav</strong><br>" +
//                   "</body>" +
//                   "</html>";
//        }
//}
//        @Override
//        public String toString() {
//            return "<html>" +
//                   "<body>" +
//                   "<table border='1' style='border-collapse: collapse; width: 100%; text-align: left;'>" +
//                   // Header Row
//                   "<tr style='background-color: orange;'>" +
//                   "<th>Route</th>" +
//                   "<th>Website Title</th>" +
//                   "<th>From</th>" +
//                   "<th>To</th>" +
//                   "<th>Date</th>" +
//                   "<th>Traveler(s) & Class</th>" +
//                   "<th>Total Flights Showing</th>" +
//                   "<th>Search Response Time</th>" +
//                   "</tr>" +
//
//                   // Widget Row
//                   "<tr>" +
//                   "<th>Widget</th>" +
//                   "<td>" + title + "</td>" +
//                   "<td>" + text1 + "</td>" +
//                   "<td>" + fromWidget + "</td>" +
//                   "<td>" + calenderWidget + "</td>" +
//                   "<td>" + travelerWidget + "</td>" +
//                   "<td colspan='2'></td>" + // Empty cells for Widget row
//                   "</tr>" +
//
//                   // Listing Row
//                   "<tr>" +
//                   "<th>Listing</th>" +
//                   "<td></td>" + // Empty cell for Website Title in Listing row
//                   "<td>" + text2 + "</td>" +
//                   "<td>" + fromDestination + "</td>" +
//                   "<td>" + calenderModified + "</td>" +
//                   "<td>" + travelerModified + "</td>" +
//                   "<td style='color:" + (totalShowing.equals("Flight not found") ? "red" : "green") + ";'>" + totalShowing + "</td>" +
//                   "<td>" + searchTime + " Seconds</td>" +
//                   "</tr>" +
//                   "</table>" +
////                   "<p style='color: black;'>Automatic mail for flights<br>" +
////                   "<strong>Keshav</strong></p>" +
//					"<br></br>"+
//                   "</body>" +
//                   "</html>";
//        }
//}
        
        @Override
        public String toString() {
            return "<html>" +
                   "<head>" +
                   "<style>" +
                   "table { width: 100%; border-collapse: collapse; }" +
                   "th, td { padding: 8px; text-align: left; border: 1px solid #ddd; }" +
                   "th { background-color: #d45c06; color: white; }" +
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
                   "<th>Date</th>" +
                   "<th>Traveler(s) & Class</th>" +
                   "<th>Total Flights Showing</th>" +
                   "<th>Available Airlines</th>" +
                   "<th>First Airline Price</th>" +
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
                   "<td>" + calenderWidget + "</td>" +
                   "<td>" + travelerWidget + "</td>" +
                   "<td style = 'text-align: center;'> NA </td>"  + // Empty cells for Widget row
                   "<td style = 'text-align: center;'> NA </td>" + // Empty cells for Widget row
                   "<td style = 'text-align: center;'> NA </td>"  +
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
                   "<td>" + calenderModified + "</td>" +
                   "<td>" + travelerModified + "</td>" +
                   "<td style='color:" + (totalShowing.equals("Flight not found") ? "red" : "green") + ";'>" + totalShowing + "</td>" +
                   "<td>" + airlinespriceSymbol + "</td>" +
                   "<td>" + firstPriceShowing + "</td>" +
                   "<td>" + searchTime + " Sec</td>" +
                   "</tr>" +
                   "</table>" +
                   "</body>" +
                   "</html>";
        }
}
