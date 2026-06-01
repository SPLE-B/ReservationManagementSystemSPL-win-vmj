package reservationmanagement.product.ayo;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Type;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import Reservation.resource.ResourceResourceFactory;
import Reservation.resource.core.resource.ResourceResource;
import Reservation.resource.ResourceServiceFactory;
import Reservation.resource.core.service.ResourceService;
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

public class Ayo {

	private static final Logger logger;
	
	static {
		logger = LoggerFactory.getLogger(Ayo.class);
	}
    
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

		configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserComponent.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserDecorator.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserImpl.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.RoleComponent.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.RoleDecorator.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.RoleImpl.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserRoleComponent.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserRoleDecorator.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.UserRoleImpl.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.core.model.User.class);
        configuration.addAnnotatedClass(id.ac.ui.cs.prices.winvmj.auth.model.passworded.model.UserImpl.class);

		configuration.addAnnotatedClass(Reservation.bookingtype.core.model.BookingType.class);
		configuration.addAnnotatedClass(Reservation.bookingtype.core.model.BookingTypeComponent.class);
		configuration.addAnnotatedClass(Reservation.bookingtype.core.model.BookingTypeDecorator.class);
		configuration.addAnnotatedClass(Reservation.bookingtype.core.model.BookingTypeImpl.class);
		configuration.addAnnotatedClass(Reservation.bookingtype.daily.model.BookingTypeImpl.class);
		configuration.addAnnotatedClass(Reservation.pricing.core.model.Pricing.class);
		configuration.addAnnotatedClass(Reservation.pricing.core.model.PricingComponent.class);
		configuration.addAnnotatedClass(Reservation.pricing.core.model.PricingDecorator.class);
		configuration.addAnnotatedClass(Reservation.pricing.core.model.PricingImpl.class);
		configuration.addAnnotatedClass(Reservation.resource.core.model.Resource.class);
		configuration.addAnnotatedClass(Reservation.resource.core.model.ResourceComponent.class);
		configuration.addAnnotatedClass(Reservation.resource.core.model.ResourceDecorator.class);
		configuration.addAnnotatedClass(Reservation.resource.core.model.ResourceImpl.class);
		configuration.addAnnotatedClass(Reservation.payment.core.model.Payment.class);
		configuration.addAnnotatedClass(Reservation.payment.core.model.PaymentComponent.class);
		configuration.addAnnotatedClass(Reservation.payment.core.model.PaymentDecorator.class);
		configuration.addAnnotatedClass(Reservation.payment.core.model.PaymentImpl.class);
		configuration.addAnnotatedClass(Reservation.payment.banktransfer.model.PaymentImpl.class);
		configuration.addAnnotatedClass(Reservation.payment.merchant.model.PaymentImpl.class);
		configuration.addAnnotatedClass(Reservation.notification.core.model.Notification.class);
		configuration.addAnnotatedClass(Reservation.notification.core.model.NotificationComponent.class);
		configuration.addAnnotatedClass(Reservation.notification.core.model.NotificationDecorator.class);
		configuration.addAnnotatedClass(Reservation.notification.core.model.NotificationImpl.class);
		configuration.addAnnotatedClass(Reservation.notification.email.model.NotificationImpl.class);
		configuration.addAnnotatedClass(Reservation.rating.core.model.Rating.class);
		configuration.addAnnotatedClass(Reservation.rating.core.model.RatingComponent.class);
		configuration.addAnnotatedClass(Reservation.rating.core.model.RatingDecorator.class);
		configuration.addAnnotatedClass(Reservation.rating.core.model.RatingImpl.class);
		configuration.addAnnotatedClass(Reservation.rating.comment.model.RatingImpl.class);

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
			logger.warn("Database connection failed - server running but database features disabled");
			logger.debug("Database error: {}", e.getMessage());
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
		logger.info("Creating objects and binding endpoints");
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
			
        BookingTypeService dailyBookingType2Service = BookingTypeServiceFactory
            .createBookingTypeService("Reservation.bookingtype.daily.service.BookingTypeServiceImpl"
            	, bookingtypeBookingType2Service);		

        BookingTypeResource dailyBookingType2Resource = BookingTypeResourceFactory
            .createBookingTypeResource("Reservation.bookingtype.daily.resource.BookingTypeResourceImpl"
                , bookingtypeBookingType2Resource);
			
        PricingService pricingPricing2Service = PricingServiceFactory
            .createPricingService("Reservation.pricing.core.service.PricingServiceImpl"
            	);		

        PricingResource pricingPricing2Resource = PricingResourceFactory
            .createPricingResource("Reservation.pricing.core.resource.PricingResourceImpl"
                );
			
        ResourceService resourceResource2Service = ResourceServiceFactory
            .createResourceService("Reservation.resource.core.service.ResourceServiceImpl"
            	);		

        ResourceResource resource2Resource = ResourceResourceFactory
            .createResourceResource("Reservation.resource.core.resource.ResourceResourceImpl"
                );
			
        PaymentService paymentPayment2Service = PaymentServiceFactory
            .createPaymentService("Reservation.payment.core.service.PaymentServiceImpl"
            	);		

        PaymentResource paymentPayment2Resource = PaymentResourceFactory
            .createPaymentResource("Reservation.payment.core.resource.PaymentResourceImpl"
                );
			
        PaymentService banktransferPayment2Service = PaymentServiceFactory
            .createPaymentService("Reservation.payment.banktransfer.service.PaymentServiceImpl"
            	, paymentPayment2Service);		

        PaymentResource banktransferPayment2Resource = PaymentResourceFactory
            .createPaymentResource("Reservation.payment.banktransfer.resource.PaymentResourceImpl"
                , paymentPayment2Resource);
			
        PaymentService paymentPayment4Service = PaymentServiceFactory
            .createPaymentService("Reservation.payment.core.service.PaymentServiceImpl"
            	);		

        PaymentResource paymentPayment4Resource = PaymentResourceFactory
            .createPaymentResource("Reservation.payment.core.resource.PaymentResourceImpl"
                );
			
        PaymentService merchantPayment2Service = PaymentServiceFactory
            .createPaymentService("Reservation.payment.merchant.service.PaymentServiceImpl"
            	, paymentPayment4Service);		

        PaymentResource merchantPayment2Resource = PaymentResourceFactory
            .createPaymentResource("Reservation.payment.merchant.resource.PaymentResourceImpl"
                , paymentPayment4Resource);
			
        NotificationService notificationNotification2Service = NotificationServiceFactory
            .createNotificationService("Reservation.notification.core.service.NotificationServiceImpl"
            	);		

        NotificationResource notificationNotification2Resource = NotificationResourceFactory
            .createNotificationResource("Reservation.notification.core.resource.NotificationResourceImpl"
                );
			
        NotificationService emailNotification2Service = NotificationServiceFactory
            .createNotificationService("Reservation.notification.email.service.NotificationServiceImpl"
            	, notificationNotification2Service);		

        NotificationResource emailNotification2Resource = NotificationResourceFactory
            .createNotificationResource("Reservation.notification.email.resource.NotificationResourceImpl"
                , notificationNotification2Resource);
			
        RatingService ratingRating2Service = RatingServiceFactory
            .createRatingService("Reservation.rating.core.service.RatingServiceImpl"
            	);		

        RatingResource ratingRating2Resource = RatingResourceFactory
            .createRatingResource("Reservation.rating.core.resource.RatingResourceImpl"
                );
			
        RatingService commentRating2Service = RatingServiceFactory
            .createRatingService("Reservation.rating.comment.service.RatingServiceImpl"
            	, ratingRating2Service);		

        RatingResource commentRating2Resource = RatingResourceFactory
            .createRatingResource("Reservation.rating.comment.resource.RatingResourceImpl"
                , ratingRating2Resource);
			

		logger.info("Binding endpoints for commentRating2Resource");
		Router.route(commentRating2Resource);
		
		logger.info("Binding endpoints for commentRating2Service");
		Router.route(commentRating2Service);
		
		logger.info("Binding endpoints for ratingRating2Resource");
		Router.route(ratingRating2Resource);
		
		logger.info("Binding endpoints for ratingRating2Service");
		Router.route(ratingRating2Service);
		
		logger.info("Binding endpoints for emailNotification2Resource");
		Router.route(emailNotification2Resource);
		
		logger.info("Binding endpoints for emailNotification2Service");
		Router.route(emailNotification2Service);
		
		logger.info("Binding endpoints for notificationNotification2Resource");
		Router.route(notificationNotification2Resource);
		
		logger.info("Binding endpoints for notificationNotification2Service");
		Router.route(notificationNotification2Service);
		
		logger.info("Binding endpoints for merchantPayment2Resource");
		Router.route(merchantPayment2Resource);
		
		logger.info("Binding endpoints for merchantPayment2Service");
		Router.route(merchantPayment2Service);
		
		logger.info("Binding endpoints for paymentPayment4Resource");
		Router.route(paymentPayment4Resource);
		
		logger.info("Binding endpoints for paymentPayment4Service");
		Router.route(paymentPayment4Service);
		
		logger.info("Binding endpoints for banktransferPayment2Resource");
		Router.route(banktransferPayment2Resource);
		
		logger.info("Binding endpoints for banktransferPayment2Service");
		Router.route(banktransferPayment2Service);
		
		logger.info("Binding endpoints for paymentPayment2Resource");
		Router.route(paymentPayment2Resource);
		
		logger.info("Binding endpoints for paymentPayment2Service");
		Router.route(paymentPayment2Service);
		
		logger.info("Binding endpoints for resource2Resource");
		Router.route(resource2Resource);
		
		logger.info("Binding endpoints for resourceResource2Service");
		Router.route(resourceResource2Service);
		
		logger.info("Binding endpoints for pricingPricing2Resource");
		Router.route(pricingPricing2Resource);
		
		logger.info("Binding endpoints for pricingPricing2Service");
		Router.route(pricingPricing2Service);
		
		logger.info("Binding endpoints for dailyBookingType2Resource");
		Router.route(dailyBookingType2Resource);
		
		logger.info("Binding endpoints for dailyBookingType2Service");
		Router.route(dailyBookingType2Service);
		
		logger.info("Binding endpoints for bookingtypeBookingType2Resource");
		Router.route(bookingtypeBookingType2Resource);
		
		logger.info("Binding endpoints for bookingtypeBookingType2Service");
		Router.route(bookingtypeBookingType2Service);
		
		logger.info("Binding auth endpoints");
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
					Reservation.bookingtype.daily.model.BookingTypeImpl.class.getName()
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
            Reservation.resource.core.model.ResourceComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					Reservation.resource.core.model.ResourceComponent.class.getName()
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
					Reservation.payment.banktransfer.model.PaymentImpl.class.getName(),
					Reservation.payment.merchant.model.PaymentImpl.class.getName()
				});
			}});
		featureModelMappings.put(
            Reservation.notification.core.model.NotificationComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					Reservation.notification.core.model.NotificationComponent.class.getName()
				});
				put("deltas", new String[] {
					Reservation.notification.email.model.NotificationImpl.class.getName()
				});
			}});
		featureModelMappings.put(
            Reservation.rating.core.model.RatingComponent.class.getName(),
			new HashMap<String, String[]>() {{ 
				put("components", new String[] {
					Reservation.rating.core.model.RatingComponent.class.getName()
				});
				put("deltas", new String[] {
					Reservation.rating.comment.model.RatingImpl.class.getName()
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
				logger.warn("Please check '{}' in your local environment variable or 'hibernate.connection.{}' in your 'hibernate.properties' file!", varname, typeProp);
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
			logger.info("cors.properties not found, using defaults (allowedMethod=GET,POST,PUT,PATCH,DELETE, allowedOrigin=*)");
        }
    }

}