package reservationmanagement.product.ayoindonesia;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Type;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import id.ac.ui.cs.prices.winvmj.core.VMJCors;
import id.ac.ui.cs.prices.winvmj.core.VMJServer;
import id.ac.ui.cs.prices.winvmj.core.Router;
import id.ac.ui.cs.prices.winvmj.hibernate.HibernateUtil;
import org.hibernate.cfg.Configuration;

import id.ac.ui.cs.prices.winvmj.auth.model.UserResourceFactory;
import id.ac.ui.cs.prices.winvmj.auth.model.RoleResourceFactory;
import id.ac.ui.cs.prices.winvmj.auth.model.core.resource.UserResource;
import id.ac.ui.cs.prices.winvmj.auth.model.core.resource.RoleResource;

import Reservation.bookingtype.BookingTypeResourceFactory;
import Reservation.bookingtype.core.resource.BookingTypeResource;
import Reservation.bookingtype.BookingTypeServiceFactory;
import Reservation.bookingtype.core.service.BookingTypeService;
import Reservation.pricing.PricingResourceFactory;
import Reservation.pricing.core.resource.PricingResource;
import Reservation.pricing.PricingServiceFactory;
import Reservation.pricing.core.service.PricingService;
import Reservation.payment.PaymentResourceFactory;
import Reservation.payment.core.resource.PaymentResource;
import Reservation.payment.PaymentServiceFactory;
import Reservation.payment.core.service.PaymentService;
import Reservation.notification.NotificationResourceFactory;
import Reservation.notification.core.resource.NotificationResource;
import Reservation.notification.NotificationServiceFactory;
import Reservation.notification.core.service.NotificationService;
import Reservation.rating.RatingResourceFactory;
import Reservation.rating.core.resource.RatingResource;
import Reservation.rating.RatingServiceFactory;
import Reservation.rating.core.service.RatingService;
import Reservation.resource.ResourceResourceFactory;
import Reservation.resource.core.resource.ResourceResource;
import Reservation.resource.ResourceServiceFactory;
import Reservation.resource.core.service.ResourceService;
import Reservation.cancellation.CancellationResourceFactory;
import Reservation.cancellation.core.resource.CancellationResource;
import Reservation.cancellation.CancellationServiceFactory;
import Reservation.cancellation.core.service.CancellationService;

public class AyoIndonesia {
    
	public static void main(String[] args) {



		// get hostAddress and portnum from env var
        // ex:
        // AMANAH_HOST_BE --> "localhost"
        // AMANAH_PORT_BE --> 7776
		String hostAddress= getEnvVariableHostAddress("AMANAH_HOST_BE");
        int portNum = getEnvVariablePortNumber("AMANAH_PORT_BE");
        activateServer(hostAddress, portNum);
		setCors();

		Configuration configuration = new Configuration();
		// panggil setter setelah membuat object dari kelas Configuration
        // ex:
        // AMANAH_DB_URL --> jdbc:postgresql://localhost:5432/superorg
        // AMANAH_DB_USERNAME --> postgres
        // AMANAH_DB_PASSWORD --> postgres123
		setDBProperties("AMANAH_DB_URL", "url", configuration);
        setDBProperties("AMANAH_DB_USERNAME", "username", configuration);
        setDBProperties("AMANAH_DB_PASSWORD","password", configuration);

		configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.Role.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.RoleComponent.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.RoleDecorator.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.RoleImpl.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserRole.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserRoleComponent.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserRoleDecorator.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserRoleImpl.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.User.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserComponent.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserDecorator.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserImpl.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.passworded.model.UserImpl.class);

		configuration.addAnnotatedClass(Reservation.bookingtype.core.model.BookingType.class);
		configuration.addAnnotatedClass(Reservation.bookingtype.core.model.BookingTypeComponent.class);
		configuration.addAnnotatedClass(Reservation.bookingtype.core.model.BookingTypeDecorator.class);
		configuration.addAnnotatedClass(Reservation.bookingtype.core.model.BookingTypeImpl.class);
		configuration.addAnnotatedClass(Reservation.pricing.core.model.Pricing.class);
		configuration.addAnnotatedClass(Reservation.pricing.core.model.PricingComponent.class);
		configuration.addAnnotatedClass(Reservation.pricing.core.model.PricingDecorator.class);
		configuration.addAnnotatedClass(Reservation.pricing.core.model.PricingImpl.class);
		configuration.addAnnotatedClass(Reservation.payment.core.model.Payment.class);
		configuration.addAnnotatedClass(Reservation.payment.core.model.PaymentComponent.class);
		configuration.addAnnotatedClass(Reservation.payment.core.model.PaymentDecorator.class);
		configuration.addAnnotatedClass(Reservation.payment.core.model.PaymentImpl.class);
		configuration.addAnnotatedClass(Reservation.notification.core.model.Notification.class);
		configuration.addAnnotatedClass(Reservation.notification.core.model.NotificationComponent.class);
		configuration.addAnnotatedClass(Reservation.notification.core.model.NotificationDecorator.class);
		configuration.addAnnotatedClass(Reservation.notification.core.model.NotificationImpl.class);
		configuration.addAnnotatedClass(Reservation.rating.core.model.Rating.class);
		configuration.addAnnotatedClass(Reservation.rating.core.model.RatingComponent.class);
		configuration.addAnnotatedClass(Reservation.rating.core.model.RatingDecorator.class);
		configuration.addAnnotatedClass(Reservation.rating.core.model.RatingImpl.class);
		configuration.addAnnotatedClass(Reservation.resource.core.model.Resource.class);
		configuration.addAnnotatedClass(Reservation.resource.core.model.ResourceComponent.class);
		configuration.addAnnotatedClass(Reservation.resource.core.model.ResourceDecorator.class);
		configuration.addAnnotatedClass(Reservation.resource.core.model.ResourceImpl.class);
		configuration.addAnnotatedClass(Reservation.cancellation.core.model.Cancellation.class);
		configuration.addAnnotatedClass(Reservation.cancellation.core.model.CancellationComponent.class);
		configuration.addAnnotatedClass(Reservation.cancellation.core.model.CancellationDecorator.class);
		configuration.addAnnotatedClass(Reservation.cancellation.core.model.CancellationImpl.class);

		Map<String, Object> featureModelMappings = mappingFeatureModel();
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, Map<String, String[]>>>(){}.getType();
        String convertedFeatureModelMappings = gson.toJson(featureModelMappings, type);
		
        configuration.setProperty("feature.model.mappings", convertedFeatureModelMappings);
		configuration.buildMappings();
		// Try to initialize Hibernate - graceful failure if DB not available
		try {
			HibernateUtil.buildSessionFactory(configuration);
			createObjectsAndBindEndPoints();
		} catch (Exception e) {
			System.out.println("== WARNING: Database connection failed ==");
			System.out.println("Server running but database features disabled.");
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void activateServer(String hostName, int portNumber) {
		VMJServer vmjServer = VMJServer.getInstance(hostName, portNumber);
		try {
			vmjServer.startServerGeneric();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void createObjectsAndBindEndPoints() {
		System.out.println("== CREATING OBJECTS AND BINDING ENDPOINTS ==");
		UserResource userResource = UserResourceFactory
            .createUserResource("id.ac.ui.cs.prices.winvmj.auth.model.core.resource.UserResourceImpl"
			);

		RoleResource roleResource = RoleResourceFactory
        	.createRoleResource("id.ac.ui.cs.prices.winvmj.auth.model.core.resource.RoleResourceImpl"
			);
        
        UserResource userPasswordedResource = UserResourceFactory
	        .createUserResource("id.ac.ui.cs.prices.winvmj.auth.model.passworded.resource.UserResourceImpl"
			,
		    UserResourceFactory.createUserResource("id.ac.ui.cs.prices.winvmj.auth.model.core.resource.UserResourceImpl"));

        BookingTypeService bookingtypeBookingType2Service = BookingTypeServiceFactory
            .createBookingTypeService("Reservation.bookingtype.core.service.BookingTypeServiceImpl"
            	);		

        BookingTypeResource bookingtypeBookingType2Resource = BookingTypeResourceFactory
            .createBookingTypeResource("Reservation.bookingtype.core.resource.BookingTypeResourceImpl"
                );
			
        PricingService pricingPricing2Service = PricingServiceFactory
            .createPricingService("Reservation.pricing.core.service.PricingServiceImpl"
            	);		

        PricingResource pricingPricing2Resource = PricingResourceFactory
            .createPricingResource("Reservation.pricing.core.resource.PricingResourceImpl"
                );
			
        PaymentService paymentPayment2Service = PaymentServiceFactory
            .createPaymentService("Reservation.payment.core.service.PaymentServiceImpl"
            	);		

        PaymentResource paymentPayment2Resource = PaymentResourceFactory
            .createPaymentResource("Reservation.payment.core.resource.PaymentResourceImpl"
                );
			
        NotificationService notificationNotification2Service = NotificationServiceFactory
            .createNotificationService("Reservation.notification.core.service.NotificationServiceImpl"
            	);		

        NotificationResource notificationNotification2Resource = NotificationResourceFactory
            .createNotificationResource("Reservation.notification.core.resource.NotificationResourceImpl"
                );
			
        RatingService ratingRating2Service = RatingServiceFactory
            .createRatingService("Reservation.rating.core.service.RatingServiceImpl"
            	);		

        RatingResource ratingRating2Resource = RatingResourceFactory
            .createRatingResource("Reservation.rating.core.resource.RatingResourceImpl"
                );
			
        ResourceService resourceResource2Service = ResourceServiceFactory
            .createResourceService("Reservation.resource.core.service.ResourceServiceImpl"
            	);		

        ResourceResource resource2Resource = ResourceResourceFactory
            .createResourceResource("Reservation.resource.core.resource.ResourceResourceImpl"
                );
			
        CancellationService cancellationCancellation2Service = CancellationServiceFactory
            .createCancellationService("Reservation.cancellation.core.service.CancellationServiceImpl"
            	);		

        CancellationResource cancellationCancellation2Resource = CancellationResourceFactory
            .createCancellationResource("Reservation.cancellation.core.resource.CancellationResourceImpl"
                );
			

		System.out.println("cancellationCancellation2Resource endpoints binding");
		Router.route(cancellationCancellation2Resource);
		
		System.out.println("cancellationCancellation2Service endpoints binding");
		Router.route(cancellationCancellation2Service);
		
		System.out.println("resource2Resource endpoints binding");
		Router.route(resource2Resource);
		
		System.out.println("resourceResource2Service endpoints binding");
		Router.route(resourceResource2Service);
		
		System.out.println("ratingRating2Resource endpoints binding");
		Router.route(ratingRating2Resource);
		
		System.out.println("ratingRating2Service endpoints binding");
		Router.route(ratingRating2Service);
		
		System.out.println("notificationNotification2Resource endpoints binding");
		Router.route(notificationNotification2Resource);
		
		System.out.println("notificationNotification2Service endpoints binding");
		Router.route(notificationNotification2Service);
		
		System.out.println("paymentPayment2Resource endpoints binding");
		Router.route(paymentPayment2Resource);
		
		System.out.println("paymentPayment2Service endpoints binding");
		Router.route(paymentPayment2Service);
		
		System.out.println("pricingPricing2Resource endpoints binding");
		Router.route(pricingPricing2Resource);
		
		System.out.println("pricingPricing2Service endpoints binding");
		Router.route(pricingPricing2Service);
		
		System.out.println("bookingtypeBookingType2Resource endpoints binding");
		Router.route(bookingtypeBookingType2Resource);
		
		System.out.println("bookingtypeBookingType2Service endpoints binding");
		Router.route(bookingtypeBookingType2Service);
		
		System.out.println("authResource endpoints binding");
		Router.route(userPasswordedResource);
		Router.route(roleResource);
		Router.route(userResource);
	}

	private static Map<String, Object> mappingFeatureModel() {
		Map<String, Object> featureModelMappings = new HashMap<>();

		featureModelMappings.put(
            Reservation.bookingtype.core.model.BookingTypeComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					Reservation.bookingtype.core.model.BookingTypeComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}});
		featureModelMappings.put(
            Reservation.pricing.core.model.PricingComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					Reservation.pricing.core.model.PricingComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}});
		featureModelMappings.put(
            Reservation.payment.core.model.PaymentComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					Reservation.payment.core.model.PaymentComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}});
		featureModelMappings.put(
            Reservation.notification.core.model.NotificationComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					Reservation.notification.core.model.NotificationComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}});
		featureModelMappings.put(
            Reservation.rating.core.model.RatingComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					Reservation.rating.core.model.RatingComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}});
		featureModelMappings.put(
            Reservation.resource.core.model.ResourceComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					Reservation.resource.core.model.ResourceComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}});
		featureModelMappings.put(
            Reservation.cancellation.core.model.CancellationComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					Reservation.cancellation.core.model.CancellationComponent.class.getName()
				});
				put("deltas", new String[] {
				});
			}});
		featureModelMappings.put(
	            id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserComponent.class.getName(),
				new HashMap<String, String[]>() {{ 
					put("components", new String[] {
						id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserComponent.class.getName()
					});
					put("deltas", new String[] {
						id.ac.ui.cs.prices.winvmj.auth.model.passworded.model.UserImpl.class.getName()
					});
				}});
        
	    featureModelMappings.put(
				id.ac.ui.cs.prices.winvmj.auth.model.core.model.RoleComponent.class.getName(),
				new HashMap<String, String[]>() {{ 
					put("components", new String[] {
						id.ac.ui.cs.prices.winvmj.auth.model.core.model.RoleComponent.class.getName()
					});
					put("deltas", new String[] {
					});
				}});
        
	    featureModelMappings.put(
				id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserRoleComponent.class.getName(),
				new HashMap<String, String[]>() {{ 
					put("components", new String[] {
						id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserRoleComponent.class.getName()
					});
					put("deltas", new String[] {
					});
				}});
        
		return featureModelMappings;
	}

	public static void setDBProperties(String varname, String typeProp, Configuration configuration) {
		String varNameValue = System.getenv(varname);
		String propertyName = String.format("hibernate.connection.%s",typeProp);
		if (varNameValue != null) {
			configuration.setProperty(propertyName, varNameValue);
		} else {
			String hibernatePropertyVal = configuration.getProperty(propertyName);
			if (hibernatePropertyVal == null) {
				String error_message = String.format("Please check '%s' in your local environment variable or "
                	+ "'hibernate.connection.%s' in your 'hibernate.properties' file!", varname, typeProp);
            	System.out.println(error_message);
			}
		}
	}

	// if the env variable for server host is null, use localhost instead.
    public static String getEnvVariableHostAddress(String varname_host){
            String hostAddress = System.getenv(varname_host)  != null ? System.getenv(varname_host) : "localhost"; // Host
            return hostAddress;
    }

    // try if the environment variable for port number is null, use 7776 instead
    public static int getEnvVariablePortNumber(String varname_port){
            String portNum = System.getenv(varname_port)  != null? System.getenv(varname_port)  : "7776"; //PORT
            int portNumInt = Integer.parseInt(portNum);
            return portNumInt;
    }
	
	public static void setCors() {
    	Properties properties = new Properties();
        String propertyValue = "";
        
        try (FileInputStream fileInput = new FileInputStream("cors.properties")) {
            properties.load(fileInput);
            propertyValue = properties.getProperty("allowedMethod");
            VMJCors.setAllowedMethod(propertyValue);
            
            propertyValue = properties.getProperty("allowedOrigin");
            VMJCors.setAllowedOrigin(propertyValue);
            
        } catch (IOException e) {
			VMJCors.setAllowedMethod("GET, POST, PUT, PATCH, DELETE");
			VMJCors.setAllowedOrigin("*");
			System.out.println("Buat file cors.properties terlebih dahulu pada src-gen/(namaProduk) dengan contoh sebagai berikut:");
			System.out.println("allowedMethod = GET, POST");
			System.out.println("allowedOrigin = http://example.com");
        }
    }

}