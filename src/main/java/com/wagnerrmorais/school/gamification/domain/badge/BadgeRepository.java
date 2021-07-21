package com.wagnerrmorais.school.gamification.domain.badge;

import com.wagnerrmorais.school.shared.domain.CPF;

import java.util.List;

public interface BadgeRepository {

    void add(Badge badge);
    List<Badge> studentsBadges(CPF cpf);

}
