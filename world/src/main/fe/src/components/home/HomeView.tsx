export default function HomeView() {
  const baseURL = process.env.NEXT_PUBLIC_API_URL;
  console.log('🚀 ~ HomeView ~ baseURL:', baseURL);

  return (
    <div className="w-[100vw] h-[100vh] flex flex-col items-center justify-center">
      <h1 className="text-black">Home</h1>
    </div>
  );
}
