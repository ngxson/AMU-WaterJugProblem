package com.ngxson.programmation.move;

import com.ngxson.programmation.Configuration;

public interface Move {
    void apply(Configuration configuration);
    void reverse(Configuration configuration);
    void display();
}
