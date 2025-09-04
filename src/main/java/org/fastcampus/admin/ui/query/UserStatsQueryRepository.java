package org.fastcampus.admin.ui.query;

import org.fastcampus.admin.ui.dto.GetDailyRegisterUserResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface UserStatsQueryRepository {
    List<GetDailyRegisterUserResponseDto> getDailyRegisterUsers(int beforeDays);
}
