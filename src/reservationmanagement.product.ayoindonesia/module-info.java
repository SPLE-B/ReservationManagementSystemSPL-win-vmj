module reservationmanagement.product.ayoindonesia {
    requires id.ac.ui.cs.prices.winvmj.auth;
    requires id.ac.ui.cs.prices.winvmj.auth.model;
    requires id.ac.ui.cs.prices.winvmj.core;
    requires id.ac.ui.cs.prices.winvmj.hibernate;
    
    requires net.bytebuddy;
    requires java.xml.bind;
    requires com.sun.xml.bind;
    requires com.fasterxml.classmate;
    requires jdk.unsupported;

    requires Reservation.bookingtype.core;
    requires Reservation.pricing.core;
    requires Reservation.payment.core;
    requires Reservation.notification.core;
    requires Reservation.rating.core;
    requires Reservation.resource.core;
    requires Reservation.cancellation.core;

}