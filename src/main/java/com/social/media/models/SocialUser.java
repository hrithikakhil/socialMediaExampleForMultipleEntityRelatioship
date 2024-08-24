package com.social.media.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "socialUser")
//    @JoinColumn(name = "social_profile_id")
    private SocialProfile profile;

    @OneToMany(mappedBy = "socialUser")
    // What is this saying?
    // The below relationship is being managed by POST class and "socialUser" is the field which is managing the relation.
    private List<Post> posts = new ArrayList<Post>();

    @ManyToMany
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "groupd_id") )
    private Set<SocialGroup> groups = new HashSet<SocialGroup>();

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }


}
