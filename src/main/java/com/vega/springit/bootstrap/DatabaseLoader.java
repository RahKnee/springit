package com.vega.springit.bootstrap;

import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private LinkRepository linkRepository;
    private CommentRepository commentRepository;

    public DatabaseLoader(LinkRepository linkRepository, CommentRepository commentRepository) {
        this.linkRepository = linkRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void run(String... args) {
        Map<String,String> links = new HashMap<>();
        links.put("I am animal Number 1  and I have no name","https://media.giphy.com/media/hFmIU5GQF18Aw/giphy.gif");
        links.put("I am animal Number 2 and I have no name","https://media.giphy.com/media/xT9IgxKsLc9nFM7n32/giphy.gif");
        links.put("I am animal Number 3 and I have no name","https://i.pinimg.com/originals/da/d8/5d/dad85d39b39e6fccb191c88cabe1e292.gif");

        /*
        links.forEach((k,v) -> {
            linkRepository.save(new Link(k,v));
            // we will do something with comments later
        });*/


        links.forEach((k,v) -> {
            Link link = new Link(k,v);
            linkRepository.save(link);

            // we will do something with comments later
/*            Comment spring = new Comment("Thank you for this link related to Spring Boot. I love it, great post!",link);
            Comment security = new Comment("I love that you're talking about Spring Security",link);
            Comment pwa = new Comment("What is this Progressive Web App thing all about? PWAs sound really cool.",link);
            Comment comments[] = {spring,security,pwa};
            for(Comment comment : comments) {
                commentRepository.save(comment);
                link.addComment(comment);
            }*/
        });

        long linkCount = linkRepository.count();
        System.out.println("Number of links in the database: " + linkCount );

    }



}

