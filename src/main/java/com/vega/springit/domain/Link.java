package com.vega.springit.domain;

import com.vega.springit.service.BeanUtil;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.ocpsoft.prettytime.PrettyTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Entity
@RequiredArgsConstructor
@Getter @Setter
@ToString
public class Link extends Auditable {
    @Id @GeneratedValue @Getter @Setter
    private  Long id;

    @NonNull
    @NotEmpty(message = "Please enter a title")
    private String title;

    @NotEmpty(message = "Please enter a url")
    @NonNull
    @URL(message = "please enter a valid url")
    private String url;

    // comments
    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<Comment>();

//    public Link(String title, String url) {
//        this.title = title;
//        this.url = url;
//    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public Long getId() {return id;}
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDomainName() throws URISyntaxException {
        URI uri = new URI(this.url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

    public String getPrettyTime() {
        PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(convertToDateViaInstant(getCreationDate()));
    }

    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

    public List<Comment> getComments() {
        return comments;
    }
}
