package com.amir.bingerwallmvp.mainscreen;

import com.amir.bingerwallmvp.data.Post;

import java.util.List;

/**
 * Created by amir on 3/19/17.
 */

public interface MainScreenContract {
    interface View {
        void showPosts(Post posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}
