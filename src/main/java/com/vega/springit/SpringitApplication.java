package com.vega.springit;

import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
        System.out.println("Welcome to spring it");
    }

//    @Bean
    CommandLineRunner runner (LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            Link link = new Link("Getting Started with Spring Bott 2", "https://therealdanvega.com/spring-boot-2");
            linkRepository.save(link);

            Comment comment = new Comment("This spring boot 2 link is awesome!", link);
            commentRepository.save(comment);
            link.addComment(comment);

            System.out.println("We just insterded a link and a comment");


//            Link firstLink = linkRepository.findByTitle("Getting Started with Spring Bott 2");
//
//            System.out.println(firstLink.getTitle());
//
//            List<Link> linkList = linkRepository.findAllByTitleLikeOrderByCreationDateDesc("%Bott%");
//            System.out.println(linkList);
        };
    }
}
