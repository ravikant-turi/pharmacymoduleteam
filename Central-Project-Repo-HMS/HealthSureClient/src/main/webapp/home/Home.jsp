<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome to HMS</title>
    <link rel="stylesheet" type="text/css" href="/HealthSureClient/resources/css/style.css" />
</head>

<body class="light-mode">
<f:view>

    <!-- INCLUDE NAVBAR -->
    <jsp:include page="/navbar/Navbar.jsp" />

    <!-- FULLSCREEN VIDEO SECTION -->
    <section id="home" class="fullscreen-video-container">
        <video autoplay muted loop class="fullscreen-video">
            <source src="/HealthSureClient/resources/media/videos/videoplayback.mp4" type="video/mp4"/>
            <h:outputText value="Your browser does not support the video tag."/>
        </video>

        <div class="appointment-button-container">
		    <h:form>
		        <div class="appointment-button-wrapper">
		            <h:commandButton 
		                value="Book Appointment"
		                action="#{appointmentBean.book}"
		                styleClass="appointment-button"/>
		        </div>
		    </h:form>
		</div>
    </section>
    
    <!-- DEPARTMENTS SECTION -->
    <section id="departments" class="section">
	<h2 class="section-title">Our Departments</h2>
    
    <div class="departments-container">
        <div class="department-card">
            <img src="/HealthSureClient/resources/media/images/departments/cardiology.png" alt="Cardiology" class="department-icon"/>
            <h3>Cardiology</h3>
            <p>Advanced care for heart-related conditions including diagnostics, surgery, and rehabilitation.</p>
        </div>
        
        <div class="department-card">
            <img src="/HealthSureClient/resources/media/images/departments/neorology.png" alt="Neurology" class="department-icon"/>
            <h3>Neurology</h3>
            <p>Specialized treatment for disorders of the brain, spinal cord, and nervous system.</p>
        </div>
        
        <div class="department-card">
            <img src="/HealthSureClient/resources/media/images/departments/arthopedics.png" alt="Orthopedics" class="department-icon"/>
            <h3>Orthopedics</h3>
            <p>Comprehensive care for bones, joints, and muscles including surgeries and physical therapy.</p>
        </div>
        
        <div class="department-card">
            <img src="/HealthSureClient/resources/media/images/departments/pediatrics.png" alt="Pediatrics" class="department-icon"/>
            <h3>Pediatrics</h3>
            <p>Dedicated to the health and wellness of infants, children, and adolescents.</p>
        </div>
        
        <div class="department-card">
            <img src="/HealthSureClient/resources/media/images/departments/gynecology.png" alt="Gynecology" class="department-icon"/>
            <h3>Gynecology</h3>
            <p>Specialized care for women’s reproductive health, pregnancy, and childbirth services.</p>
        </div>

        <div class="department-card">
            <img src="/HealthSureClient/resources/media/images/departments/dermatology.png" alt="Dermatology" class="department-icon"/>
            <h3>Dermatology</h3>
            <p>Diagnosis and treatment of skin, hair, and nail disorders, including cosmetic dermatology.</p>
        </div>

        <div class="department-card">
            <img src="/HealthSureClient/resources/media/images/departments/ent.png" alt="ENT" class="department-icon"/>
            <h3>ENT</h3>
            <p>Comprehensive care for ear, nose, and throat conditions, including sinus and voice disorders.</p>
        </div>

        <div class="department-card">
            <img src="/HealthSureClient/resources/media/images/departments/oncology.png" alt="Oncology" class="department-icon"/>
            <h3>Oncology</h3>
            <p>Cutting-edge cancer care through chemotherapy, radiation, surgery, and targeted therapy.</p>
        </div>

        <div class="department-card">
            <img src="/HealthSureClient/resources/media/images/departments/nephrology.png" alt="Nephrology" class="department-icon"/>
            <h3>Nephrology</h3>
            <p>Expert care for kidney diseases, dialysis services, and transplant follow-up.</p>
        </div>

        <div class="department-card">
            <img src="/HealthSureClient/resources/media/images/departments/urology.png" alt="Urology" class="department-icon"/>
            <h3>Urology</h3>
            <p>Specialized treatment for urinary tract issues and male reproductive health.</p>
        </div>

        <div class="department-card">
            <img src="/HealthSureClient/resources/media/images/departments/gastroenterology.png" alt="Gastroenterology" class="department-icon"/>
            <h3>Gastroenterology</h3>
            <p>Advanced diagnostics and treatment for digestive system disorders and liver conditions.</p>
        </div>

        <div class="department-card">
            <img src="/HealthSureClient/resources/media/images/departments/psychiatry.png" alt="Psychiatry" class="department-icon"/>
            <h3>Psychiatry</h3>
            <p>Mental health services including counseling, psychotherapy, and medication management.</p>
        </div>
    </div>
	</section>
		
	<!-- DOCTORS SECTION -->
	<section id="doctors" class="section slide-up">
	    <h2 class="section-title">Our Doctors</h2>
	
	    <div class="doctors-container">
	        <div class="doctor-card zoom-in">
	            <img src="/HealthSureClient/resources/media/images/doctors/doctor1.jpg" alt="Dr. Aryan Mehta" class="doctor-photo"/>
	            <h3>Dr. Aryan Mehta</h3>
	            <p>Cardiologist with 10+ years of experience in interventional procedures and heart surgery.</p>
	        </div>
	
	        <div class="doctor-card zoom-in">
	            <img src="/HealthSureClient/resources/media/images/doctors/doctor2.jpg" alt="Dr. Rhea Sharma" class="doctor-photo"/>
	            <h3>Dr. Rhea Sharma</h3>
	            <p>Neurologist specializing in epilepsy, stroke, and movement disorders with a decade of clinical excellence.</p>
	        </div>
	
	        <div class="doctor-card zoom-in">
	            <img src="/HealthSureClient/resources/media/images/doctors/doctor3.jpg" alt="Dr. Kunal Verma" class="doctor-photo"/>
	            <h3>Dr. Kunal Verma</h3>
	            <p>Orthopedic Surgeon expert in joint replacement and sports injuries with global surgical exposure.</p>
	        </div>
	
	        <div class="doctor-card zoom-in">
	            <img src="/HealthSureClient/resources/media/images/doctors/doctor4.jpg" alt="Dr. Sneha Iyer" class="doctor-photo"/>
	            <h3>Dr. Sneha Iyer</h3>
	            <p>Pediatrician passionate about child wellness, immunization, and early development screening.</p>
	        </div>
	        
	        <div class="doctor-card zoom-in">
            <img src="/HealthSureClient/resources/media/images/doctors/doctor5.jpg" alt="Dr. Nikhil Rao" class="doctor-photo"/>
            <h3>Dr. Nikhil Rao</h3>
            <p>Dermatologist experienced in treating chronic skin conditions and aesthetic skin procedures.</p>
        </div>

        <div class="doctor-card zoom-in">
            <img src="/HealthSureClient/resources/media/images/doctors/doctor6.jpg" alt="Dr. Ayesha Khan" class="doctor-photo"/>
            <h3>Dr. Ayesha Khan</h3>
            <p>Gynecologist specializing in high-risk pregnancies, fertility treatments, and laparoscopic surgeries.</p>
        </div>

        <div class="doctor-card zoom-in">
            <img src="/HealthSureClient/resources/media/images/doctors/doctor7.jpg" alt="Dr. Rohan Desai" class="doctor-photo"/>
            <h3>Dr. Rohan Desai</h3>
            <p>ENT specialist skilled in sinus surgeries, hearing loss treatments, and voice disorders.</p>
        </div>

        <div class="doctor-card zoom-in">
            <img src="/HealthSureClient/resources/media/images/doctors/doctor8.jpg" alt="Dr. Meera Bhatt" class="doctor-photo"/>
            <h3>Dr. Meera Bhatt</h3>
            <p>Oncologist with deep expertise in chemotherapy, targeted therapy, and patient counseling.</p>
        </div>
        
	    </div>
	</section>
	
	<!-- ABOUT US SECTION -->
	<section id="aboutus" class="section slide-up">
	    <h2 class="section-title">About Us</h2>
	    
	    <p class="section-content">
	        At <strong>HealthSure</strong>, we believe that healthcare should be a right, not a privilege. We aim to make quality medical services accessible to everyone through innovation, compassion, and care.
	    </p>
	
	    <p class="section-content" style="margin-top: 1rem;">
	        With a state-of-the-art infrastructure, dedicated staff, and modern diagnostic technology, we ensure that every patient receives personalized attention and the highest standard of treatment.
	    </p>
	
	    <!-- 🔢 Animated Counters -->
	    <div class="about-counters">
	        <div class="counter-box">
	            <div class="counter" data-target="500">0</div>
	            <p>Expert Doctors</p>
	        </div>
	        <div class="counter-box">
	            <div class="counter" data-target="1200">0</div>
	            <p>Happy Patients</p>
	        </div>
	        <div class="counter-box">
	            <div class="counter" data-target="250">0</div>
	            <p>Advanced Facilities</p>
	        </div>
	        <div class="counter-box">
	            <div class="counter" data-target="24">0</div>
	            <p>Hours Emergency Care</p>
	        </div>
	    </div>
	
	    <!-- ACHIEVEMENTS -->
	    <div class="about-features">
	        <div class="feature-item">
	            <img src="/HealthSureClient/resources/media/images/certificate.png" alt="Certified" class="feature-icon" />
	            <h4>Internationally Certified</h4>
	            <p>We follow global standards and protocols with NABH and JCI certifications.</p>
	        </div>
	        <div class="feature-item">
	            <img src="/HealthSureClient/resources/media/images/certificate.png" alt="AI Diagnosis" class="feature-icon" />
	            <h4>AI-Driven Diagnostics</h4>
	            <p>Advanced AI systems to enhance diagnosis speed and precision.</p>
	        </div>
	        <div class="feature-item">
	            <img src="/HealthSureClient/resources/media/images/certificate.png" alt="24x7 Support" class="feature-icon" />
	            <h4>24x7 Patient Support</h4>
	            <p>Round-the-clock assistance with instant emergency response teams.</p>
	        </div>
	    </div>
	</section>

	<!-- CONTACT SECTION -->
	<section id="contact" class="section contact-section slide-up">
	    <h2 class="section-title">Contact Us</h2>
	    <p class="section-content">We’re here to answer your questions, assist with appointments, or hear your feedback!</p>
	
	    <div class="contact-card-container">
	        <!-- Contact Form -->
	        <form class="contact-form-glass">
	            <div class="form-group">
	                <i class="fas fa-user"></i>
	                <input type="text" placeholder="Your Name" required />
	            </div>
	            <div class="form-group">
	                <i class="fas fa-envelope"></i>
	                <input type="email" placeholder="Your Email" required />
	            </div>
	            <div class="form-group">
	                <i class="fas fa-heading"></i>
	                <input type="text" placeholder="Subject" required />
	            </div>
	            <div class="form-group">
	                <i class="fas fa-comment"></i>
	                <textarea rows="4" placeholder="Your Message" required></textarea>
	            </div>
	            <button type="submit" class="send-button">Send Message</button>
	        </form>
	
	        <!-- Info Card -->
	        <div class="contact-info-glass">
	            <h3>Get in Touch</h3>
	            <p><i class="fas fa-map-marker-alt"></i> 123 HealthSure Street, Bengaluru, India</p>
	            <p><i class="fas fa-envelope"></i> support@healthsure.com</p>
	            <p><i class="fas fa-phone-alt"></i> +91 99999 99999</p>
	            <p><i class="fas fa-clock"></i> Mon–Sat: 9AM – 8PM</p>
	        </div>
	    </div>
	</section>


</f:view>
</body>

<jsp:include page="/footer/Footer.jsp" />

<script>
document.addEventListener("DOMContentLoaded", function () {
    const counters = document.querySelectorAll('.counter');

    const startCounter = (counter) => {
        const target = +counter.getAttribute('data-target');
        const duration = 4000; // in ms
        const step = Math.ceil(target / (duration / 30)); // frames every 30ms
        let current = 0;

        const updateCount = () => {
            current += step;
            if (current >= target) {
                counter.innerText = target + "+";
            } else {
                counter.innerText = current;
                requestAnimationFrame(updateCount);
            }
        };
        updateCount();
    };

    // Trigger animation only when in viewport
    const observer = new IntersectionObserver(entries => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                startCounter(entry.target);
                observer.unobserve(entry.target); // Animate once
            }
        });
    }, { threshold: 0.5 });

    counters.forEach(counter => observer.observe(counter));
});
</script>
</html>
