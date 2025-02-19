package team.aliens.dms.domain.notification.spi

import team.aliens.dms.domain.notification.model.DeviceToken
import java.util.UUID

interface QueryDeviceTokenPort {

    fun existsDeviceTokenByUserId(userId: UUID): Boolean

    fun queryDeviceTokenByUserId(userId: UUID): DeviceToken?

    fun queryDeviceTokenByToken(token: String): DeviceToken?
}
