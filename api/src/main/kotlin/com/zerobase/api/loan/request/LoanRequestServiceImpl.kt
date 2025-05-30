package com.zerobase.api.com.zerobase.api.loan.request

import com.zerobase.api.com.zerobase.api.loan.GeneratedKey
import com.zerobase.api.com.zerobase.api.loan.encrypt.EncryptComponent
import com.zerobase.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class LoanRequestServiceImpl(
    private val generatedKey: GeneratedKey,
    private val userInfoRepository: UserInfoRepository,
    private val encryptComponent: EncryptComponent
): LoanRequestService {

    override fun loanRequestMain(
        loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto {
        val userKey = generatedKey.generateUserKey()

        loanRequestInputDto.userRegistrationNumber =
            encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber)

        saveUserInfo(loanRequestInputDto.toUserInfoDto(userKey))

        loanRequestReview(userKey)

        return LoanRequestDto.LoanRequestResponseDto(userKey)
    }

    override fun saveUserInfo(userInfoDto: UserInfoDto) =
        userInfoRepository.save(userInfoDto.toEntity())


    override fun loanRequestReview(userKey: String) {

    }
}