import Head from 'next/head'
import Image from 'next/image'
import { useState } from 'react'
import { useForm, SubmitHandler } from 'react-hook-form'
import { LoginInputs } from '../../types'
import "../../styles/Login.module.scss"


export default function Login(): React.ReactElement {
     
  const [login, setLogin] = useState(false)
  const [loading, handleLoading] = useState<Boolean>(false);

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<LoginInputs>()
    
  const onSubmit: SubmitHandler<LoginInputs> = async (data: LoginInputs) => {
    handleLoading(true)
    console.log("Auth data", data)
    handleLoading(false)
    //     console.log(data)
    //     // if (login) {
    //     //   await signIn(data.email, data.password)
    //     // } else {
    //     //   await signUp(data.email, data.password)
    //     // }
  }
    

  return (
    <div className="h-screen w-screen bg-[url('../public/assets/loginBg.jpg')]">
      
      <a href="#" className='text-[#e50914] text-[2em]'><svg viewBox="0 0 111 30" data-uia="netflix-logo" className="fill-[#e50914] w-[6em] h-[3em] pl-5 pt-0" aria-hidden="true" focusable="false"><g id="netflix-logo"><path d="M105.06233,14.2806261 L110.999156,30 C109.249227,29.7497422 107.500234,29.4366857 105.718437,29.1554972 L102.374168,20.4686475 L98.9371075,28.4375293 C97.2499766,28.1563408 95.5928391,28.061674 93.9057081,27.8432843 L99.9372012,14.0931671 L94.4680851,-5.68434189e-14 L99.5313525,-5.68434189e-14 L102.593495,7.87421502 L105.874965,-5.68434189e-14 L110.999156,-5.68434189e-14 L105.06233,14.2806261 Z M90.4686475,-5.68434189e-14 L85.8749649,-5.68434189e-14 L85.8749649,27.2499766 C87.3746368,27.3437061 88.9371075,27.4055675 90.4686475,27.5930265 L90.4686475,-5.68434189e-14 Z M81.9055207,26.93692 C77.7186241,26.6557316 73.5307901,26.4064111 69.250164,26.3117443 L69.250164,-5.68434189e-14 L73.9366389,-5.68434189e-14 L73.9366389,21.8745899 C76.6248008,21.9373887 79.3120255,22.1557784 81.9055207,22.2804387 L81.9055207,26.93692 Z M64.2496954,10.6561065 L64.2496954,15.3435186 L57.8442216,15.3435186 L57.8442216,25.9996251 L53.2186709,25.9996251 L53.2186709,-5.68434189e-14 L66.3436123,-5.68434189e-14 L66.3436123,4.68741213 L57.8442216,4.68741213 L57.8442216,10.6561065 L64.2496954,10.6561065 Z M45.3435186,4.68741213 L45.3435186,26.2498828 C43.7810479,26.2498828 42.1876465,26.2498828 40.6561065,26.3117443 L40.6561065,4.68741213 L35.8121661,4.68741213 L35.8121661,-5.68434189e-14 L50.2183897,-5.68434189e-14 L50.2183897,4.68741213 L45.3435186,4.68741213 Z M30.749836,15.5928391 C28.687787,15.5928391 26.2498828,15.5928391 24.4999531,15.6875059 L24.4999531,22.6562939 C27.2499766,22.4678976 30,22.2495079 32.7809542,22.1557784 L32.7809542,26.6557316 L19.812541,27.6876933 L19.812541,-5.68434189e-14 L32.7809542,-5.68434189e-14 L32.7809542,4.68741213 L24.4999531,4.68741213 L24.4999531,10.9991564 C26.3126816,10.9991564 29.0936358,10.9054269 30.749836,10.9054269 L30.749836,15.5928391 Z M4.78114163,12.9684132 L4.78114163,29.3429562 C3.09401069,29.5313525 1.59340144,29.7497422 0,30 L0,-5.68434189e-14 L4.4690224,-5.68434189e-14 L10.562377,17.0315868 L10.562377,-5.68434189e-14 L15.2497891,-5.68434189e-14 L15.2497891,28.061674 C13.5935889,28.3437998 11.906458,28.4375293 10.1246602,28.6868498 L4.78114163,12.9684132 Z" id="Fill-14"></path></g></svg></a>

      <form className='bg-[#000000bf] rounded-[4px] w-4/12 mx-auto z-10' onSubmit={handleSubmit(onSubmit)}>
        <div className='mx-14 py-10'>
          <h1 className='text-white text-[2em] font-bold mb-6'>Sign In</h1>

          {/* Email Input */}
          <div className='w-full mb-6'>
            <input
            type="email"
            id="email"
            className='bg-[#333] p-3 py-[0.8em] w-full text-white rounded-[4px] mb-2 outline-none'
            placeholder='Email'
            {...register("email", {
              required: "Please enter a valid email",
              pattern: /\S+@\S+\.\S+/,
            })}
            />
             <span className="text-red-600 text-xs block mt-2">
            {errors.email && errors.email.message}
          </span> 
           </div>

          {/* Password Input */}
          <div className='w-full mb-6'>
            <input
            type="password"
            id='password'
            className='bg-[#333] p-3 py-[0.8em] w-full text-white rounded-[4px] mb-2 outline-none'
            placeholder='Password'
            {...register("password", {
              required: "Please enter password",
            })}
            />
             <span className="text-red-600 text-[14px] block mt-2">
            {errors.password && errors.password.message}
          </span>
          </div>
          

          <button type="submit" className='w-full bg-[#e50914] text-white p-3 font-bold rounded-[5px]'>Sign In</button>
          <p className='text-[#737373] py-4'>New to Netflix? <a href='/auth/register' className='text-white font-bold cursor-pointer'>Sign Up now</a></p>
        </div>
        

      </form>


      </div>
  )

}