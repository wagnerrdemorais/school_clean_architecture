package com.wagnerrmorais.school.gamification.application;

import com.wagnerrmorais.school.gamification.domain.badge.Badge;
import com.wagnerrmorais.school.gamification.domain.badge.BadgeRepository;
import com.wagnerrmorais.school.shared.domain.CPF;
import com.wagnerrmorais.school.shared.domain.event.Event;
import com.wagnerrmorais.school.shared.domain.event.EventListener;
import com.wagnerrmorais.school.shared.domain.event.EventType;

public class GenerateNoviceStudentBadge extends EventListener {

    private final BadgeRepository badgeRepository;

    public GenerateNoviceStudentBadge(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    @Override
    protected void reactTo(Event event) {
        CPF studentCpf = (CPF) event.eventInfo().get("cpf");
        Badge noviceBadge = new Badge(studentCpf, "Novice");
        badgeRepository.add(noviceBadge);
    }

    @Override
    protected boolean shouldProcess(Event event) {
        return event.type() == EventType.ENROLLED_STUDENT;
    }
}
