package com.zerobase.api.com.zerobase.api.loan

import org.springframework.stereotype.Component
import java.util.UUID

@Component
class GeneratedKey {
    fun generateUserKey() = UUID.randomUUID().toString().replace("-", "")
}