package team.aliens.dms.domain.remain.usecase

import team.aliens.dms.common.annotation.ReadOnlyUseCase
import team.aliens.dms.domain.remain.dto.QueryCurrentAppliedRemainOptionResponse
import team.aliens.dms.domain.remain.service.RemainService
import team.aliens.dms.domain.user.service.UserService

@ReadOnlyUseCase
class QueryCurrentAppliedRemainOptionUseCase(
    private val userService: UserService,
    private val remainService: RemainService
) {

    fun execute(): QueryCurrentAppliedRemainOptionResponse {

        val user = userService.getCurrentUser()

        val remainStatus = remainService.getRemainStatusById(user.id)

        val appliedRemainOption = remainService.getRemainOptionById(remainStatus.remainOptionId, user.schoolId)

        return QueryCurrentAppliedRemainOptionResponse(
            title = appliedRemainOption.title
        )
    }
}
