def findmaximum_sub_array(arr, low_index, high_index):
   if low_index==high_index:
     return (low_index,low_index,arr[low_index])
   else:
    mid=int((low_index+high_index)/2)
    il,jl,tl=findmaximum_sub_array(arr,low_index,mid)
    ir,jr,tr=findmaximum_sub_array(arr,mid+1,high_index)
    is2,js,ts=maximum_sum(arr,low_index,mid,high_index)
    t=max(tl,tr,ts)
    if t==tl:
     return (il,jl,tl)
    elif t==tr:
     return (ir,jr,tr)
    else:
     return (is2,js,ts)
def maximum_sum(arr,low_index,mid,high_index):
  max_left=mid+1
  max_right=mid+2
  left_sum = float('-inf')
  s2=0
  for i in range(mid,low_index-1,-1):
     s2=s2+arr[i]
     if s2>left_sum:
       left_sum = s2
       max_left = i
  right_sum = float('-inf')
  s2 = 0
  for j in range(mid+1,high_index+1):
     s2 = s2 + arr[j]
     if s2 > right_sum:
      right_sum = s2
      max_right = j
  return (max_left,max_right,left_sum + right_sum)

print("enter the numbers with comma")
array=list(map(int,input().split(",")))
n=len(array)
low_index=0
high_index=n-1
left_index,right_index,s = findmaximum_sub_array(array,low_index,high_index)
print("left index",left_index)
print ("right index",right_index)
print("maximum sub array sum is",s)

