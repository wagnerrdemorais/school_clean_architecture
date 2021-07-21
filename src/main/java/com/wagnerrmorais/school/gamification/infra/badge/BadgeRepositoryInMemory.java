package com.wagnerrmorais.school.gamification.infra.badge;

import com.wagnerrmorais.school.gamification.domain.badge.Badge;
import com.wagnerrmorais.school.gamification.domain.badge.BadgeRepository;
import com.wagnerrmorais.school.shared.domain.CPF;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BadgeRepositoryInMemory implements BadgeRepository {

    private List<Badge> badgeList = new ArrayList<>();

    @Override
    public void add(Badge badge) {
        this.badgeList.add(badge);
    }

    @Override
    public List<Badge> studentsBadges(CPF cpf) {
        return this.badgeList.stream()
                .filter(badge -> badge.getStudentCPF().equals(cpf))
                .collect(Collectors.toList());
    }
}
