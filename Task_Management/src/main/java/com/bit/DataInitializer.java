/*
 * package com.bit;
 * 
 * import com.bit.entity.UserEntity; import com.bit.repository.UserRepository;
 * import org.springframework.boot.CommandLineRunner; import
 * org.springframework.stereotype.Component;
 * 
 * import java.util.Arrays;
 * 
 * @Component public class DataInitializer implements CommandLineRunner {
 * 
 * private final UserRepository userRepository;
 * 
 * public DataInitializer(UserRepository userRepository) { this.userRepository =
 * userRepository; }
 * 
 * @Override public void run(String... args) throws Exception { // Create sample
 * users UserEntity user1 = new UserEntity(); user1.setUsername("john_doe");
 * user1.setEmail("john.doe@example.com");
 * 
 * UserEntity user2 = new UserEntity(); user2.setUsername("jane_smith");
 * user2.setEmail("jane.smith@example.com");
 * 
 * userRepository.saveAll(Arrays.asList(user1, user2)); } }
 */