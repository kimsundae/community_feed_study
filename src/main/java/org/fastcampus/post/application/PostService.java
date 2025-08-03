package org.fastcampus.post.application;

import org.fastcampus.post.domain.Post;
import org.fastcampus.post.application.dto.CreatePostRequestDto;
import org.fastcampus.post.application.dto.LikeRequestDto;
import org.fastcampus.post.application.interfaces.LikeRepository;
import org.fastcampus.post.application.interfaces.PostRepository;
import org.fastcampus.user.application.UserService;
import org.fastcampus.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private final LikeRepository likeRepository;

    public PostService(PostRepository postRepository, UserService userService, LikeRepository likeRepository) {
        this.postRepository = postRepository;
        this.userService = userService;
        this.likeRepository = likeRepository;
    }

    public Post getPost(Long id){
        return postRepository.findById(id);
    }

    public Post createPost(CreatePostRequestDto dto){
        User author = userService.getUser(dto.userId());
        Post post = Post.createPost(author.getId(), author, dto.content(), dto.state());
        return postRepository.save(post);
    }

    public Post updatePost(Long id, CreatePostRequestDto dto){
        Post post = getPost(id);
        User user = userService.getUser(dto.userId());

        post.updatePost(user, dto.content(), dto.state());
        return  postRepository.save(post);
    }

    public void likePost(LikeRequestDto dto){
        Post post = getPost(dto.targetId());
        User user = userService.getUser(dto.userId());

        if(likeRepository.checkLike(post, user)){
            return;
        }

        post.like(user);
        likeRepository.like(post, user);
    }

    public void unlikePost(LikeRequestDto dto){
        Post post = getPost(dto.targetId());
        User user = userService.getUser(dto.userId());

        if(likeRepository.checkLike(post, user)){
            post.unLike();
            likeRepository.unlike(post, user);
        }
    }
}
