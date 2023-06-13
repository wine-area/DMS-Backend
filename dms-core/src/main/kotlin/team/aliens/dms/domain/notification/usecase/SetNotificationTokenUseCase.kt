package team.aliens.dms.domain.notification.usecase

import team.aliens.dms.common.annotation.UseCase
import team.aliens.dms.domain.notification.dto.SetNotificationTokenRequest
import team.aliens.dms.domain.notification.service.NotificationService
import team.aliens.dms.domain.user.service.UserService

@UseCase
class SetNotificationTokenUseCase(
    private val userService: UserService,
    private val notificationService: NotificationService
) {

    fun execute(request: SetNotificationTokenRequest) {
        val user = userService.getCurrentUser()

        notificationService.saveDeviceToken(
            request.toNotificationToken(user)
        )
    }
}
